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

    public void confirm() throws IOException {
        String weightGoalText = weightGoal.getText();
        String distanceGoalText = distanceGoal.getText();
        if (!weightGoalText.matches("[0-9]{1,}")) {
            invalidDataType("Ideal weight");
        } else if (!distanceGoalText.matches("[0-9]{1,}")) {
            invalidDataType("Distance goal");
        } else {
            // Write to the weightGaol file.
            updateWeightGoal(weightGoalText);

            // Write to the distanceGoal file.
            updateDistanceGoal(distanceGoalText);
        }
    }

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

    public void invalidDataType(String data) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Kenko");
        alert.setHeaderText("Invalid " + data);
        alert.setContentText("Please try again" + "\n" + "If you don't have a secondary goal please enter a 0.");
        alert.showAndWait();
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
}
