package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    public void openProgress()throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("progress.fxml"));
        Stage newAccStage = new Stage();
        Scene scene = new Scene(part);

        newAccStage.setScene(scene);
        newAccStage.setTitle("Kenko");
        newAccStage.show();
    }
    public void openUpdateInfo()throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("updateInfo.fxml"));
        Stage newAccStage = new Stage();
        Scene scene = new Scene(part);
        newAccStage.setScene(scene);
        newAccStage.setTitle("Kenko");
        newAccStage.show();
    }

    public void openWorkout()throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("workout.fxml"));
        Stage newAccStage = new Stage();
        Scene scene = new Scene(part);
        newAccStage.setScene(scene);
        newAccStage.setTitle("Kenko");
        newAccStage.show();
    }

    public void openUpdateProgress()throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("updateProgress.fxml"));
        Stage newAccStage = new Stage();
        Scene scene = new Scene(part);
        newAccStage.setScene(scene);
        newAccStage.setTitle("Kenko");
        newAccStage.show();
    }
}
