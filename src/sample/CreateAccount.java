package sample;

import java.awt.*;
import java.io.*;

import javafx.fxml.FXML;
import java.io.FileWriter;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.*;


public class CreateAccount{


    //Taking out age
    @FXML
    private TextField name,surname,email,username, password,age;




    public void createAccount2() throws IOException
    {
        // Taking the user input from the application and storing it
        String name_text = name.getText();
        String surname_text = surname.getText();
        String age_text = age.getText();
        int age_txt = Integer.parseInt(age_text);
        String email_text = email.getText();
        String username_text = username.getText();
        String password_text = password.getText();
        //Validation checks
        if (!validUsername(username_text))
        {
            System.out.println("Invalid Username");
        }
        else if (!validPassword(password_text))
        {
            System.out.println("Invalid Password");
        }
        else if (!validEmail(email_text))
        {
            System.out.println("Invalid Email");
        }

        //If the data passes the validation checks it is written to files.
        else{
            System.out.println("Valid account");
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
            FileWriter fileWriter3 = new FileWriter("accounts.csv", true);
            BufferedWriter bwr3 = new BufferedWriter(fileWriter3);
            bwr3.write(name_text + "," + surname_text + "," + email_text + "," + username_text + "," + password_text);
            bwr3.write("\n");
            bwr3.flush();
            bwr3.close();

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
    public boolean usernameExists(String checkUsername)
    {
        BufferedReader bufferedReader = null;
        String fileName =  "usernames.csv";
        String line = "";
        String csvSplitBy="\n";

        try
        {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null)
            {
                String [] name = line.split(csvSplitBy);
                for (String string : name)
                {
                    if (string == checkUsername)
                    {
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

    // Method that checks that the username is longer than 3 characters
    // and can only contain a-z, A-Z, 0-9, points, dashes and underscores.
    public boolean validUsername(String username)
    {
        if (usernameExists(username))
        {
            return false;
        }
        if (!username.matches("[a-zA-Z0-9.\\-_]{3,}"))
        {
            return false;
        }
        return true;
    }


    // Method to check for the email in the email folder.
    public boolean emailExists(String checkEmail)
    {
        BufferedReader bufferedReader = null;
        String fileName =  "emails.csv";
        String line = "";
        String csvSplitBy="\n";
        try
        {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null)
            {
                String [] name = line.split(csvSplitBy);
                for (String string : name)
                {
                    if (string == checkEmail)
                    {
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

    // Method to check the email is valid (it doesn't already exist and it fulfills the regex)
    // returns true if valid, false if not.
    public boolean validEmail(String checkEmail)
    {
        if (emailExists(checkEmail))
        {
            return false;
        }
        if (!checkEmail.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}" +
                "[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"))
        {
            return false;
        }
        return true;
    }




    // Method that checks that the password is between 8-20 chars, must contain one uppercase,
    // one lowercase and one special char
    public boolean validPassword(String password)
    {
        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[#$^+=!*()@%&]).{8,20}$"))
        {
            return false;
        }
        return true;
    }



}
