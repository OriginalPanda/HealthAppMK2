package sample;

import java.io.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


// Represents behind the scenes logic and all background code.
public class Login {
    public Button loginButton;

    @FXML
    private TextField username, password;


    public void login() throws IOException {
        String username_text = username.getText();
        String password_text = password.getText();
        if (validAccount(username_text, password_text)) {
            Parent part = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Stage newAccStage = new Stage();
            Scene scene = new Scene(part);
            newAccStage.setTitle("Kenko");
            newAccStage.setScene(scene);
            newAccStage.show();
        } else {
            invalidLoginAlert();
        }
    }

    public void invalidLoginAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Kenko");
        alert.setHeaderText("Invalid login.");
        alert.setContentText("The login details you have entered do not currently exist. Please try again or create" +
                "a new account.");
        alert.showAndWait();
    }


    // Uses username txt file to check for a username.

    /**
     * @param checkUsername
     * @param checkPassword
     * @return
     */
    public boolean validAccount(String checkUsername, String checkPassword) {
        BufferedReader bufferedReader = null;
        String fileName = "accounts.csv";
        String line = "";
        String csvSplitBy = ",";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] name = line.split(csvSplitBy);
                String username = name[3];
                String password = name[4];
                if (checkUsername.equals(username)) {
                    if (checkPassword.equals(password)) {
                        saveCurrentUser(username);
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

    /**
     * Method to write to a CSV the username of the username of the current user who is logged in
     *
     * @param username
     * @throws IOException
     */
    public void saveCurrentUser(String username) throws IOException {
        FileWriter fileWriter = new FileWriter("currentUser.csv");
        BufferedWriter bwr = new BufferedWriter(fileWriter);
        bwr.write(username);
        bwr.flush();
        bwr.close();
    }


    public void openCreateAccount() throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
        Stage newAccStage = new Stage();
        Scene scene = new Scene(part);
        newAccStage.setScene(scene);
        newAccStage.setTitle("Kenko");
        newAccStage.show();
    }
}