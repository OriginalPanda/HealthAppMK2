package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;

public class Progress {

    @FXML
    private ProgressBar weightProgressBar, distanceProgressBar;

    /**
     * Method to display the user's weight progression in the form of a graph
     */
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
                if (username.equals(currentUser()))
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

    /**
     * Method to display the distance graph (tracking the user's distance progress)
     */
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
                if (username.equals(currentUser()))
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

    /**
     * Method to retrieve the current user's username
     * @return username
     */
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

    /**
     * Method to update both of the progress bars with how close to user's goal weight and distance they are.
     */
    public void updateProgressBars() {
        distanceProgressBar.setProgress(distanceProgressValue());
        weightProgressBar.setProgress(weightProgressValue());
    }

    /**
     * Method to retrieve the user's current weight
     * @return currentWeight
     */
    public double getCurrWeight() {
        double currWeight = 0;
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
        System.out.println("weight: "+currWeight);
        return currWeight;
    }

    /**
     * Method to retrieve the user's goal weight
     * @return goalWeight
     */
    public double getGoalWeight() {
        double goalWeight = 0;
        BufferedReader bufferedReader = null;
        String fileName = "weightGoal.csv";
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

    /**
     * Method to calculate how close the user is to hitting their goal weight using goal & current weight
     * @return weightProgressValue (as a decimal)
     */
    public double weightProgressValue() {
        double goalWeight = getGoalWeight();
        double currentWeight = getCurrWeight();
        if (currentWeight > goalWeight)
        {
            return (goalWeight / currentWeight);
        }
        else {
            return (currentWeight / goalWeight);
        }
    }


    /**
     * Method to retrieve the user's current distance
     * @return currentDistance
     */
    public double getCurrDistance() {
        double currDistance = 0;
        BufferedReader bufferedReader = null;
        String fileName = "distances.csv";
        String line = "";
        String csvSplitBy = ",";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(csvSplitBy);
                String username = split[0];
                if (username.equals(currentUser()))
                {
                    currDistance = Integer.parseInt(split[split.length - 1]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return currDistance;
    }

    /**
     * Method to retrieve the user's goal distance
     * @return goalDistance
     */
    public double getGoalDistance() {
        double goalDistance = 0;
        BufferedReader bufferedReader = null;
        String fileName = "distanceGoal.csv";
        String line = "";
        String csvSplitBy = ",";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(csvSplitBy);
                String username = split[0];
                if (username.equals(currentUser()))
                {
                    goalDistance = Integer.parseInt(split[(split.length - 1)]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return goalDistance;
    }

    /**
     * Method to calculate how close the user is to hitting their goal distance using goal & current weight
     * @return distanceProgressValue (as a decimal)
     */
    public double distanceProgressValue() {
        return (getCurrDistance() / getGoalDistance());
    }

    /**
     * Method to retrieve the user's height
     * @return height
     */
    public double getHeight() {
        double height = 0;
        BufferedReader bufferedReader = null;
        String fileName = "accounts.csv";
        String line = "";
        String csvSplitBy = ",";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(csvSplitBy);
                String username = split[3];
                if (username.equals(currentUser()))
                {
                    height = Integer.parseInt(split[(6)]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return height;
    }

    /**
     * Method to calculate the BMI of the logged in user from their height and weight
     * @return BMI value
     */
    public double calculateBMI(){
        return ((getCurrWeight() /(getHeight()*getHeight()))/0.0001);
    }

    /**
     * A method to display an alert to the user showing their BMI value along with the ranges for which category
     * they fall in and the ranges.
     */
    public void displayBMI()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kenko");
        String bmiCat = "";
        double bmiVal = calculateBMI();
        if (bmiVal < 18.5)
        {
            bmiCat = "Underweight";
        }
        else if (18.5 < bmiVal && bmiVal < 24.9)
        {
            bmiCat = "healthy";
        }
        else if (25 < bmiVal && bmiVal < 29.9)
        {
            bmiCat = "overweight";
        }
        else{
            bmiCat = "obese";
        }
        alert.setHeaderText("Your BMI is: " + bmiVal + " this means that you are: " + bmiCat);
        alert.setContentText("Here are the BMI ranges: \n" +
                "below 18.5 – you're in the underweight range.\n" +
                "between 18.5 and 24.9 – you're in the healthy weight range.\n" +
                "between 25 and 29.9 – you're in the overweight range.\n" +
                "between 30 and 39.9 – you're in the obese range.");
        alert.showAndWait();
    }
}
