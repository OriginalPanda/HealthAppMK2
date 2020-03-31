package sample;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javafx.scene.control.TextField;

public class UpdateProgress {

    @FXML
    private TextField w2,d2,h2;

    public void update() throws IOException
    {
        String weightText = w2.getText();
        String distanceText = d2.getText();
        String heightText = h2.getText();
        updateWeights(weightText);
        //
    }

    /**
     * A method to update the ...
     * @param weight
     */
    public void updateWeights(String weight) throws IOException
    {
        BufferedReader bufferedReader = null;
        String fileName =  "weights.csv";
        String line = "";
        String csvSplitBy=",";
        String oldText = "";
        String newText = "";
        try
        {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null)
            {
                oldText = oldText + line + "\r\n";
                String [] name = line.split(csvSplitBy);
                String username = name[0];
                if (username.equals(currentUser()))
                {
                    newText = oldText.replace(line,line +","+ weight);
                }
                else {
                    newText = newText + line;
                }
            }
            FileWriter writer = new FileWriter("weights.csv");
            writer.write(newText);
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
    }

    public void updateDistance()
    {
        BufferedReader bufferedReader = null;
        String fileName =  "distance.csv";
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
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
    }

    public String currentUser()
    {
        BufferedReader bufferedReader = null;
        String fileName =  "currentUser.csv";
        String line = "";
        try
        {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null)
            {
                return line;
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
        return null;
    }
}
