package sample;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private LineChart<String, Integer> lineChart;

    @FXML
    private CategoryAxis xLine;

    @FXML
    private NumberAxis yLine;

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xBar;

    @FXML
    private NumberAxis yBar;

    @FXML
    private PieChart pieChart;

    @FXML
    void initialize() {
        int hist[] = new int[10];
        for (int i = 0; i < hist.length; i++)
            hist[i] = 0;
        for (int j = 0; j < 1000; j++) {
            double value = Math.random() * 10;
            hist[(int)Math.floor(value)]++;
        }


        //line chart
        xLine.setLabel("Ranges");
        yLine.setLabel("Frequencies");
        XYChart.Series<String,Integer> series = new XYChart.Series();
        for (int i = 0; i < hist.length; i++)
            series.getData().add(new XYChart.Data<>(i + "-" + (i+1), hist[i]));


        //bar chart
        XYChart.Series<String,Integer> series2 = new XYChart.Series();
        for (int i = 0; i < hist.length; i++)
            series2.getData().add(new XYChart.Data<>(i + "-" + (i+1), hist[i]));
        series.setName("Histogram");

        //pie chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (int i = 0; i < hist.length; i++)
            pieChartData.add(new PieChart.Data(i + "-" + (i+1), hist[i]));



        pieChart.setTitle("Histogram");

        lineChart.getData().add(series);
        barChart.getData().add(series2);
        pieChart.setData(pieChartData);


    }
}
