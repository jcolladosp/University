package controller;

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
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import jgpx.model.analysis.Chunk;
import jgpx.model.analysis.TrackData;
import jgpx.util.DateTimeUtils;

/**
 * FXML Controller class
 *
 * @author jcolladosp
 */
public class StatsWindowController implements Initializable {

    @FXML
    private AreaChart<Number, Number> chartA;
    @FXML
    private LineChart<Number, Number> chartB;
    @FXML
    private LineChart<Number, Number> chartC;
    @FXML
    private LineChart<Number, Number> chartD;
    @FXML
    private PieChart chartE;
    @FXML
    private Label label_startdate;
    @FXML
    private Label label_duration;

    private TrackData trackData;
    @FXML
    private Label label_exercisetime;
    @FXML
    private Label label_totaldistance;
    @FXML
    private Label label_averagepedale;
    @FXML
    private Label label_accumulatedslope;
    @FXML
    private Label label_maximumspeed;
    @FXML
    private Label label_averagespeed;
    @FXML
    private Label label_hearth;
    @FXML
    private Label label_maximumpedale;
    @FXML
    private NumberAxis y_A;
    @FXML
    private NumberAxis x_A;
    @FXML
    private Label label_slopedown;
    @FXML
    private TextField field_hr;
    @FXML
    private Button button_chart;
    @FXML
    private CheckBox check_timeA;

    public XYChart.Series<Number, Number> seriesAt;
    public XYChart.Series<Number, Number> seriesBt;
    public XYChart.Series<Number, Number> seriesCt;
    public XYChart.Series<Number, Number> seriesDt;
    
    public XYChart.Series<Number, Number> seriesA;
    public XYChart.Series<Number, Number> seriesB;
    public XYChart.Series<Number, Number> seriesC;
    public XYChart.Series<Number, Number> seriesD;
    @FXML
    private VBox label_meter;
    @FXML
    private Label mter_lab;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void storeTrackData(TrackData a, XYChart.Series<Number, Number> seriesA, XYChart.Series<Number, Number> seriesB, XYChart.Series<Number, Number> seriesC,
            XYChart.Series<Number, Number> seriesD, XYChart.Series<Number, Number> seriesAtt, XYChart.Series<Number, Number> seriesBtt,
            XYChart.Series<Number, Number> seriesCtt, XYChart.Series<Number, Number> seriesDtt) {

        trackData = a;

        //labels information
        label_startdate.setText(DateTimeUtils.format(trackData.getStartTime()));
        label_duration.setText(toHMS(trackData.getTotalDuration().toMillis()));
        label_exercisetime.setText(toHMS(trackData.getMovingTime().toMillis()));
        label_totaldistance.setText(String.format("%.2f km", trackData.getTotalDistance() / 1000));
        label_averagepedale.setText(String.format("%d ppm", trackData.getAverageCadence()));
        label_maximumpedale.setText(String.format("%d ppm", trackData.getMaxCadence()));
        label_accumulatedslope.setText(String.format("%.2f meters", trackData.getTotalAscent()));
        label_slopedown.setText(String.format("%.2f meters", trackData.getTotalDescend()));
        label_maximumspeed.setText(String.format("%.0f km/h", trackData.getMaxSpeed() * 3.6));
        label_averagespeed.setText(String.format("%.0f km/h", trackData.getAverageSpeed() * 3.6));
        label_hearth.setText(String.format("%d / %d / %d", trackData.getMaxHeartrate(), trackData.getMinHeartRate(), trackData.getAverageHeartrate()));

        chartA.getData().add(seriesA);
        chartB.getData().add(seriesB);
        chartC.getData().add(seriesC);
        chartD.getData().add(seriesD);

        seriesAt = seriesAtt;
        seriesBt = seriesBtt;
        seriesCt = seriesCtt;
        seriesDt = seriesDtt;
        
        this.seriesA = seriesA;
        this.seriesB = seriesB;
        this.seriesC = seriesC;
        this.seriesD = seriesD;

    }

    public String toHMS(long a) {
        String hms = String.format("%02dh %02dm %02ds", TimeUnit.MILLISECONDS.toHours(a),
                TimeUnit.MILLISECONDS.toMinutes(a) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(a)),
                TimeUnit.MILLISECONDS.toSeconds(a) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(a)));
        return hms;
    }

    @FXML
    private void onShow(ActionEvent event) {
            
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        try{    
        int maxhr = Integer.parseInt(field_hr.getText());

        ObservableList<Chunk> chunks = trackData.getChunks();

        int z1 = 0;
        int z2 = 0;
        int z3 = 0;
        int z4 = 0;
        int z5 = 0;
        for (int i = 0; i < chunks.size(); i++) {
            int gethr = (int) chunks.get(i).getAvgHeartRate();

            if (gethr < maxhr * 0.6) {
                z1++;
            } else if (gethr >= maxhr * 0.6 && gethr < maxhr * 0.7) {
                z2++;
            } else if (gethr >= maxhr * 0.7 && gethr < maxhr * 0.8) {
                z3++;
            } else if (gethr >= maxhr * 0.8 && gethr < maxhr * 0.9) {
                z4++;
            } else {
                z5++;
            }

        }

        pieChartData.add(new PieChart.Data("Z1 Recovery", z1));
        pieChartData.add(new PieChart.Data("Z2 Endurance", z2));
        pieChartData.add(new PieChart.Data("Z3 Tempo", z3));
        pieChartData.add(new PieChart.Data("Z4 Threshold", z4));
        pieChartData.add(new PieChart.Data("Z5 Anaerobic", z5));

        chartE.setData(pieChartData);}
        catch(Exception e){field_hr.setText("NaN!");}
    }

    @FXML
    private void onTimeA(ActionEvent event) {
        if(!check_timeA.isSelected()){
        mter_lab.setText("in meters");
        chartA.getData().clear();
        chartA.getData().add(seriesA);       
        chartB.getData().clear();
        chartB.getData().add(seriesB);
        chartC.getData().clear();
        chartC.getData().add(seriesC);
        chartD.getData().clear();
        chartD.getData().add(seriesD);
        }
        else{
        mter_lab.setText("in minutes");
        chartA.getData().clear();
        chartA.getData().add(seriesAt);       
        chartB.getData().clear();
        chartB.getData().add(seriesBt);
        chartC.getData().clear();
        chartC.getData().add(seriesCt);
        chartD.getData().clear();
        chartD.getData().add(seriesDt);
        
        
        }
    }

}
