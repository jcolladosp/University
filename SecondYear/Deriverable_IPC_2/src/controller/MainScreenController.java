/*
 * Copyright (C) 2016 Jose Collado San Pedro <jocolsan at inf.upv.es>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package controller;

import javafx.scene.image.Image;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ProgressBar;
import javax.xml.bind.JAXBElement;
import jgpx.model.analysis.Chunk;
import jgpx.model.analysis.TrackData;
import jgpx.model.gpx.Track;
import jgpx.model.jaxb.GpxType;
import jgpx.model.jaxb.TrackPointExtensionT;

/**
 * FXML Controller class
 *
 * @author colla
 */
public class MainScreenController implements Initializable {

    @FXML
    private Button load_button;

    private TrackData trackData;

    public XYChart.Series<Number, Number> seriesA;
    public XYChart.Series<Number, Number> seriesB;
    public XYChart.Series<Number, Number> seriesC;
    public XYChart.Series<Number, Number> seriesD;
    public XYChart.Series<Number, Number> seriesAt;
    public XYChart.Series<Number, Number> seriesBt;
    public XYChart.Series<Number, Number> seriesCt;
    public XYChart.Series<Number, Number> seriesDt;

    ObservableList<PieChart.Data> pieChartData;

    @FXML
    private Button example_button;
    @FXML
    private ProgressBar progress_bar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        load_button.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/gpx.png"))));
        example_button.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/example.png"))));

    }

    @FXML
    private void onLoad(ActionEvent event) {

        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("GPX file", "*.gpx"));
        File file = chooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

        loadFile(file, null, false);

    }

    @FXML
    private void onExample(ActionEvent event) {
        URL root = getClass().getResource("/model/example.gpx");
        loadFile(null, root, true);

    }

    public void loadFile(File file, URL url, boolean example) {

        Task<Long> task = new Task<Long>() {
           

            @Override
            protected Long call() throws Exception {

                long f = 1;

                JAXBContext jaxbContext = JAXBContext.newInstance(GpxType.class, TrackPointExtensionT.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                JAXBElement<Object> root;

                if (!example) {
                    root = (JAXBElement<Object>) unmarshaller.unmarshal(file);
                } else {
                    root = (JAXBElement<Object>) unmarshaller.unmarshal(url);
                }

                GpxType gpx = (GpxType) root.getValue();

                trackData = new TrackData(new Track(gpx.getTrk().get(0)));

                //series
                ObservableList<Chunk> chunks = trackData.getChunks();
                seriesA = new XYChart.Series();
                seriesB = new XYChart.Series();
                seriesC = new XYChart.Series();
                seriesD = new XYChart.Series();
                seriesAt = new XYChart.Series();
                seriesBt = new XYChart.Series();
                seriesCt = new XYChart.Series();
                seriesDt = new XYChart.Series();
                double acumulated = 0;
                double time = 0;
                System.out.println(chunks.size());

                for (int i = 0; i < chunks.size(); i++) {

                    double xd = ((chunks.get(i).getDistance() + acumulated));
                    time = chunks.get(i).getDuration().toMillis() + time;

                    if (i % 3 == 0) {

                        seriesA.getData().add(new XYChart.Data<>(xd, chunks.get(i).getAvgHeight()));
                        seriesB.getData().add(new XYChart.Data<>(xd, chunks.get(i).getSpeed()*3.6));
                        seriesC.getData().add(new XYChart.Data<>(xd, chunks.get(i).getAvgHeartRate()));
                        seriesD.getData().add(new XYChart.Data<>(xd, chunks.get(i).getAvgCadence()));
                    }

                    double timexd = time / 60000;

                    seriesAt.getData().add(new XYChart.Data<>(timexd, chunks.get(i).getAvgHeight()));
                    seriesBt.getData().add(new XYChart.Data<>(timexd, chunks.get(i).getSpeed()*3.6));
                    seriesCt.getData().add(new XYChart.Data<>(timexd, chunks.get(i).getAvgHeartRate()));
                    seriesDt.getData().add(new XYChart.Data<>(timexd, chunks.get(i).getAvgCadence()));

                    acumulated += chunks.get(i).getDistance();

                }

                return f;
            }
        };
        progress_bar.progressProperty().bind(task.progressProperty());
        progress_bar.visibleProperty().bind(task.runningProperty());

        task.setOnSucceeded((WorkerStateEvent event) -> {
            try {

                FXMLLoader charger = new FXMLLoader(getClass().getResource("/view/StatsWindow.fxml"));
                Parent root = charger.load();
                Scene scene = new Scene(root);

                StatsWindowController passTrackData = charger.<StatsWindowController>getController();
                passTrackData.storeTrackData(trackData, seriesA, seriesB, seriesC, seriesD, seriesAt, seriesBt, seriesCt, seriesDt);

                Stage window = new Stage();
                window.setTitle("Session overview - RotoSoft");
                window.setScene(scene);
                window.setResizable(true);
                window.setMinHeight(550.0);
                window.setMinWidth(1200.0);
                window.show();

            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Problem with the file");
                alert.setContentText("There was a problem with the file, choose a correct one.");
                alert.showAndWait();
            }
        });

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

    }
}
