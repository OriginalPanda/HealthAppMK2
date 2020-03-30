package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


// Represents behind the scenes logic and all background code.
public class Login {

    public Button loginButton;

    @FXML
    private TextField username, password;


    public void login() throws IOException
    {

        String username_text = username.getText();
        String password_text = password.getText();
        if (validAccount(username_text, password_text))
        {
            Parent part = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Stage newAccStage = new Stage();
            Scene scene = new Scene(part);
            newAccStage.setScene(scene);
            newAccStage.setTitle("Kenko");
            newAccStage.show();
        }

        else{
            System.out.println("Invalid login");
        }
    }




    // Uses username txt file to check for a username.
    public boolean validAccount(String checkUsername, String checkPassword)
    {
        BufferedReader bufferedReader = null;
        String fileName =  "accounts.csv";
        String line = "";
        String csvSplitBy=",";

        try
        {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null)
            {
                String [] name = line.split(csvSplitBy);
                String username = name[3];
                String password = name[4];
                //System.out.println("R user " + username +" chk U "+ checkUsername);
                //System.out.println((checkUsername.equals(username)));
                //System.out.println("R pw "+ password + " chk P "+checkPassword);
                if (checkUsername.equals(username))
                {
                    System.out.println("user exists");
                    if (checkPassword.equals(password))
                    {
                        System.out.println("success");
                        return true;
                    }
                }
            }
            return false;
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
        return false;
    }



    public void createAccount() throws IOException
    {
        Parent part = FXMLLoader.load(getClass().getResource("createAcc.fxml"));
        Stage newAccStage = new Stage();
        Scene scene = new Scene(part);

        newAccStage.setScene(scene);
        newAccStage.setTitle("Kenko");
        newAccStage.show();

    }









}






