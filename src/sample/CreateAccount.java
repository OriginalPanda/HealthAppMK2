package sample;

import java.io.*;

import javafx.fxml.FXML;

import java.io.FileWriter;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.*;

public class CreateAccount {
    @FXML
    private TextField firstName, surname, email, username,
            password, age, weight, height, weightGoal, distanceGoal, currDistance;

    public void createAccount2() throws IOException {
        // Taking the user input from the application and storing it
        String firstName_text = firstName.getText();
        String surname_text = surname.getText();
        String age_text = age.getText();
        String email_text = email.getText();
        String username_text = username.getText();
        String password_text = password.getText();
        String weight_text = weight.getText();
        String height_text = height.getText();
        String weightGoal_text = weightGoal.getText();
        String distanceGoal_text = distanceGoal.getText();
        String currDistance_text = currDistance.getText();
        //Validation checks
        if (!validUsername(username_text)) {
            invalidUsernameError();
        } else if (!validPassword(password_text)) {
            invalidPasswordError();
        } else if (!validEmail(email_text)) {
            invalidEmailError();
        } else if (!weight_text.matches("[0-9]{1,}")) {
            invalidDataType("weight");
        } else if (!age_text.matches("[0-9]{1,}")) {
            invalidDataType("age");
        } else if (!height_text.matches("[0-9]{1,}")) {
            invalidDataType("height");
        } else if (!weightGoal_text.matches("[0-9]{1,}")) {
            invalidDataType("Weight Goal");
        } else if (!distanceGoal_text.matches("[0-9]{1,}")) {
            invalidDataType("Distance Goal");
        } else if (!currDistance_text.matches("[0-9]{1,}")) {
            invalidDataType("Current distance");
        }
        //If the data passes the validation checks it is written to files.
        else {
            // Need to initialise the users here

            // The files are split up so that the individual files can be searched to see if there
            // is already a username or email in the separate txt files.

            // Write to the username file.
            FileWriter fileWriter = new FileWriter("usernames.csv", true);
            BufferedWriter bwr = new BufferedWriter(fileWriter);
            bwr.write(username_text);
            bwr.write("\n");
            bwr.flush();
            bwr.close();

            // Write to the email file.
            FileWriter fileWriter2 = new FileWriter("emails.csv", true);
            BufferedWriter bwr2 = new BufferedWriter(fileWriter2);
            bwr2.write(email_text);
            bwr2.write("\n");
            bwr2.flush();
            bwr2.close();

            // Write to the account file.
            // Saves to CSV as: fName, sName, email, uName, pWord, weight, height, age, weight goal, distance goal
            FileWriter fileWriter3 = new FileWriter("accounts.csv", true);
            BufferedWriter bwr3 = new BufferedWriter(fileWriter3);
            bwr3.write(firstName_text + "," + surname_text + "," + email_text + "," + username_text + ","
                    + password_text + "," + weight_text + "," + height_text + ","
                    + age_text + weightGoal_text + distanceGoal_text);
            bwr3.write("\n");
            bwr3.flush();
            bwr3.close();

            // Write to the weights file
            FileWriter fileWriter4 = new FileWriter("weights.csv", true);
            BufferedWriter bwr4 = new BufferedWriter(fileWriter4);
            bwr4.write(username_text + "," + weight_text);
            bwr4.write("\n");
            bwr4.flush();
            bwr4.close();

            // Write to the distance goal file
            FileWriter fileWriter5 = new FileWriter("distanceGoal.csv", true);
            BufferedWriter bwr5 = new BufferedWriter(fileWriter5);
            bwr5.write(username_text + "," + distanceGoal_text);
            bwr5.write("\n");
            bwr5.flush();
            bwr5.close();

            // Write to the weights goal file
            FileWriter fileWriter6 = new FileWriter("weightGoal.csv", true);
            BufferedWriter bwr6 = new BufferedWriter(fileWriter6);
            bwr6.write(username_text + "," + weightGoal_text);
            bwr6.write("\n");
            bwr6.flush();
            bwr6.close();


            // Write to the distance file
            FileWriter fileWriter7 = new FileWriter("distance.csv", true);
            BufferedWriter bwr7 = new BufferedWriter(fileWriter7);
            bwr7.write(username_text + "," + weightGoal_text);
            bwr7.write("\n");
            bwr7.flush();
            bwr7.close();

            openMenu();
        }
    }

    public void openMenu() throws IOException {
        Parent part = load(getClass().getResource("menu.fxml"));
        Stage newAccStage = new Stage();
        Scene scene = new Scene(part);

        newAccStage.setScene(scene);
        newAccStage.setTitle("Kenko");
        newAccStage.show();
    }

    // Uses username txt file to check for a username.
    public boolean usernameExists(String checkUsername) {
        BufferedReader bufferedReader = null;
        String fileName = "usernames.csv";
        String line = "";
        String csvSplitBy = "\n";

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] name = line.split(csvSplitBy);
                for (String string : name) {
                    if (string == checkUsername) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    // Method that checks that the username is longer than 3 characters
    // and can only contain a-z, A-Z, 0-9, points, dashes and underscores.
    public boolean validUsername(String username) {
        if (usernameExists(username)) {
            return false;
        }
        if (!username.matches("[a-zA-Z0-9.\\-_]{3,}")) {
            return false;
        }
        return true;
    }


    // Method to check for the email in the email folder.
    public boolean emailExists(String checkEmail) {
        BufferedReader bufferedReader = null;
        String fileName = "emails.csv";
        String line = "";
        String csvSplitBy = "\n";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] name = line.split(csvSplitBy);
                for (String string : name) {
                    if (string == checkEmail) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    // Method to check the email is valid (it doesn't already exist and it fulfills the regex)
    // returns true if valid, false if not.
    public boolean validEmail(String checkEmail) {
        if (emailExists(checkEmail)) {
            return false;
        }
        if (!checkEmail.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}" +
                "[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
            return false;
        }
        return true;
    }

    // Method that checks that the password is between 8-20 chars, must contain one uppercase,
    // one lowercase and one special char
    public boolean validPassword(String password) {
        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[#$^+=!*()@%&]).{8,20}$")) {
            return false;
        }
        return true;
    }

    public void invalidUsernameError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Kenko");
        alert.setHeaderText("Invalid username.");
        alert.setContentText("Either there is a username already registered or does not follow the valid structure." +
                " Username must be longer than 3 characters and contain ONLY letters, numbers, points, " +
                "dashes and underscores.");
        alert.showAndWait();
    }

    public void invalidPasswordError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Kenko");
        alert.setHeaderText("Invalid password.");
        alert.setContentText("Please create a secure password. It must be 8-20 chars, contain an uppercase, lowercase and special char ");
        alert.showAndWait();
    }


    public void invalidEmailError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Kenko");
        alert.setHeaderText("Invalid email.");
        alert.setContentText("Please enter a valid email address");
        alert.showAndWait();
    }

    public void invalidDataType(String data) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Kenko");
        alert.setHeaderText("Invalid " + data);
        alert.setContentText("Please try again");
        alert.showAndWait();
    }
}
