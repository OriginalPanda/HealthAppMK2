package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;


public class Progress {
    //@FXML
    //private Button graphButton;

    @FXML
    private ProgressBar weightProgressBar, distanceProgressBar;

    public void displayWeightGraph() {
        Stage stage = new Stage();
        stage.setTitle("Kenko");

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Weeks");
        yAxis.setLabel("Weight");

        //creating the chart
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Weight Progression");

        //defining a series
        XYChart.Series series = new XYChart.Series();

        //populating the series with data
        // Reading from CSV and populating the series with the data.
        BufferedReader bufferedReader = null;
        String fileName = "weights.csv";
        String line = "";
        String csvSplitBy = ",";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(csvSplitBy);
                String username = split[0];
                if (username.equals(currentUser())) // Null until we work out how to solve
                {
                    int j = 0;
                    for (int i = 1; i < split.length; i++) {
                        int weight = Integer.parseInt(split[i]);
                        series.getData().add(new XYChart.Data(j, weight));
                        j++;
                    }
                    Scene scene = new Scene(lineChart, 800, 600);
                    lineChart.getData().add(series);

                    stage.setScene(scene);
                    stage.show();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        lineChart.getData().add(series);
        stage.show();
    }


    public void displayGraphDistance() {
        Stage stage = new Stage();
        stage.setTitle("Kenko");


        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Weeks");
        yAxis.setLabel("Distance");

        //creating the chart
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Distance Progression");

        //defining a series
        XYChart.Series series = new XYChart.Series();

        //populating the series with data
        // Reading from CSV and populating the series with the data.
        BufferedReader bufferedReader = null;
        String fileName = "distances.csv";
        String line = "";
        String csvSplitBy = ",";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(csvSplitBy);
                String username = split[0];
                if (username.equals(currentUser())) // Null until we work out how to solve
                {
                    int j = 0;
                    for (int i = 1; i < split.length; i++) {
                        int distance = Integer.parseInt(split[i]);
                        series.getData().add(new XYChart.Data(j, distance));
                        j++;
                    }
                    Scene scene = new Scene(lineChart, 800, 600);
                    lineChart.getData().add(series);

                    stage.setScene(scene);
                    stage.show();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        lineChart.getData().add(series);
        stage.show();
    }

    public String currentUser() {
        BufferedReader bufferedReader = null;
        String fileName = "currentUser.csv";
        String line = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                return line;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public void updateProgressBars() {
        distanceProgressBar.setProgress(distanceProgressValue());
        weightProgressBar.setProgress(weightProgressValue());
    }

    public double getCurrWeight() {
        double currWeight = 0;
        //populating the series with data
        // Reading from CSV and populating the series with the data.
        BufferedReader bufferedReader = null;
        String fileName = "weights.csv";
        String line = "";
        String csvSplitBy = ",";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(csvSplitBy);
                String username = split[0];
                if (username.equals(currentUser())) // Null until we work out how to solve
                {
                    currWeight = Integer.parseInt(split[(split.length - 1)]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return currWeight;
    }

    public double getGoalWeight() {
        double goalWeight = 0;
        //populating the series with data
        // Reading from CSV and populating the series with the data.
        BufferedReader bufferedReader = null;
        String fileName = "weights.csv";
        String line = "";
        String csvSplitBy = ",";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(csvSplitBy);
                String username = split[0];
                if (username.equals(currentUser())) // Null until we work out how to solve
                {
                    goalWeight = Integer.parseInt(split[(split.length - 1)]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return goalWeight;
    }


    public double weightProgressValue() {
        double weightValue = 0;
        weightValue = (getGoalWeight() / getCurrWeight());
        return weightValue;
    }


    public double getCurrDistance() {
        double currDistance = 0;
        //populating the series with data
        // Reading from CSV and populating the series with the data.
        BufferedReader bufferedReader = null;
        String fileName = "distances.csv";
        String line = "";
        String csvSplitBy = ",";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(csvSplitBy);
                String username = split[0];
                if (username.equals(currentUser())) // Null until we work out how to solve
                {
                    currDistance = Integer.parseInt(split[split.length - 1]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return currDistance;
    }

    public double getGoalDistance() {
        double goalDistance = 0;
        //populating the series with data
        // Reading from CSV and populating the series with the data.
        BufferedReader bufferedReader = null;
        String fileName = "distances.csv";
        String line = "";
        String csvSplitBy = ",";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(csvSplitBy);
                String username = split[0];
                if (username.equals(currentUser())) // Null until we work out how to solve
                {
                    goalDistance = Integer.parseInt(split[(split.length - 1)]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return goalDistance;
    }

    public double distanceProgressValue() {
        double weightValue = (getCurrDistance() / getGoalDistance());
        return weightValue;
    }
}
