package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.awt.*;
import java.io.*;

public class SetGoals {
    public Button confirm;

    @FXML
    private TextField weightGoal, distanceGoal;

    /**
     * Method to take the users input and update the CSV files and give the user confirmation
     * @throws IOException
     */
    public void setGoals() throws IOException {
        String weightGoalText = weightGoal.getText();
        String distanceGoalText = distanceGoal.getText();
        if (!weightGoalText.matches("[0-9]{1,}")) {
            invalidDataType("Ideal weight");
        } else if (!distanceGoalText.matches("[0-9]{1,}")) {
            invalidDataType("Distance goal");
        } else {
            updateWeightGoal(weightGoalText);
            updateDistanceGoal(distanceGoalText);
            confirmationMessage();
        }
    }

    /**
     * Method to update the CSV with the user's new weight goal
     * @param weight - new weight goal to update with
     * @throws IOException
     */
    public void updateWeightGoal(String weight) throws IOException {
        BufferedReader bufferedReader = null;
        String fileName = "weightGoal.csv";
        String line = "";
        String csvSplitBy = ",";
        String oldText = "";
        String newText = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                oldText = oldText + line + "\r\n";
                String[] name = line.split(csvSplitBy);
                String username = name[0];
                // If the line holds data for the current user
                if (username.equals(currentUser())) {
                    newText = oldText.replace(line, line + "," + weight);
                }
                // If the line is other user data
                else {
                    newText = newText + line + "\n";
                }
            }
            // Write the new data back to the csv file
            FileWriter writer = new FileWriter("weightGoal.csv");
            writer.write(newText);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Method to update the CSV with the user's new distance goal
     * @param distance - new distance goal to update with
     * @throws IOException
     */
    public void updateDistanceGoal(String distance) throws IOException {
        BufferedReader bufferedReader = null;
        String fileName = "distanceGoal.csv";
        String line = "";
        String csvSplitBy = ",";
        String oldText = "";
        String newText = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                oldText = oldText + line + "\r\n";
                String[] name = line.split(csvSplitBy);
                String username = name[0];
                // If the line holds data for the current user
                if (username.equals(currentUser())) {
                    newText = oldText.replace(line, line + "," + distance);
                }
                // If the line is other user data
                else {
                    newText = newText + line + "\n";
                }
            }
            // Write the new data back to the csv file
            FileWriter writer = new FileWriter("distanceGoal.csv");
            writer.write(newText);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Method to alert the user that their data is incorrect.
     */
    public void invalidDataType(String data) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Kenko");
        alert.setHeaderText("Invalid " + data);
        alert.setContentText("Please try again" + "\n" + "If you don't have a secondary goal please enter a 0.");
        alert.showAndWait();
    }

    /**
     * Method to confirm to the user that their data has been updated.
     */
    public void confirmationMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Kenko");
        alert.setHeaderText("Successfully updated");
        alert.setContentText("Your new goal had been set!");
        alert.showAndWait();
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
}
