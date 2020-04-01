package sample;

import javafx.fxml.FXML;
import java.io.*;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class UpdateProgress {

    @FXML
    private TextField w2, d2;

    /**
     * Error message for if the user enters the wrong data type
     * @param data - the field that is incorrect
     */
    public void invalidDataType(String data) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Kenko");
        alert.setHeaderText("Invalid " + data);
        alert.setContentText("Please try again"+ "\n" + "If you don't have a progress for this please enter a 0.");
        alert.showAndWait();
    }

    /**
     * A method to update the user's progress if the data all formatted correctly
     * @throws IOException
     */
    public void update() throws IOException {
        String weightText = w2.getText();
        String distanceText = d2.getText();
        if (!weightText.matches("[0-9]{1,}")) {
            invalidDataType("Weight Goal");
        }
        else  if(!distanceText.matches("[0-9]{1,}")) {
            invalidDataType("Distance Goal");
        }
        else{
            updateWeights(weightText);
            updateDistance(distanceText);
            confirmationMessage();
        }
    }

    /**
     * Method to confirm to the user that their data has been updated.
     */
    public void confirmationMessage() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Kenko");
        alert.setHeaderText("Successfully updated");
        alert.setContentText("Your progress has been updated!" +"\n"+ "Keep up the good work warrior.");
        alert.showAndWait();
    }


    /**
     * A method to update the user's weight and save the data
     * @param weight - the user weight to update the file with
     */
    public void updateWeights(String weight) throws IOException {
        BufferedReader bufferedReader = null;
        String fileName = "weights.csv";
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
            FileWriter writer = new FileWriter("weights.csv");
            writer.write(newText);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * A method to update the user's distance and save the data
     * @param distance - the user distance to update the file with
     */
    public void updateDistance(String distance) {
        BufferedReader bufferedReader = null;
        String fileName = "distances.csv";
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
            FileWriter writer = new FileWriter("distances.csv");
            writer.write(newText);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * A method to find out which user is currently logged into the system.
     * @return username - of the logged in user
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
