package sample;

import javafx.scene.chart.NumberAxis;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;

import static javafx.application.Application.launch;

public class Progress extends Application
{
    public void start(Stage stage) {
        stage.setTitle("Kenko");

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        yAxis.setLabel("Weight");

        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle("Weight Progression");

        //defining a series
        XYChart.Series series = new XYChart.Series();

        //populating the series with data
        // Reading from CSV and populating the series with the data.
        BufferedReader bufferedReader = null;
        String fileName =  "weights.csv";
        String line = "";
        String csvSplitBy=",";
        try
        {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null)
            {
                System.out.println("b");
                String [] split = line.split(csvSplitBy);
                String username = split[0];
                if (username.equals("wdwwdwd")) // Null until we work out how to solve
                {
                    System.out.println("a");
                    for (int i =1; i < split.length; i++)
                    {
                        int weight = Integer.parseInt(split[i]);
                        series.getData().add(new XYChart.Data(i, weight));
                    }
                    Scene scene  = new Scene(lineChart,800,600);
                    lineChart.getData().add(series);

                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }


        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch(args);
    }

}
