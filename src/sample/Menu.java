package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Menu {

    /**
     * Method to open the progress scene
     * @throws IOException
     */
    public void openProgress() throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("progress.fxml"));
        Stage newAccStage = new Stage();
        Scene scene = new Scene(part);

        newAccStage.setScene(scene);
        newAccStage.setTitle("Kenko");
        newAccStage.show();
    }

    /**
     * Method to open the set goals scene
     * @throws IOException
     */
    public void openSetGoals() throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("setGoals.fxml"));
        Stage newAccStage = new Stage();
        Scene scene = new Scene(part);
        newAccStage.setScene(scene);
        newAccStage.setTitle("Kenko");
        newAccStage.show();
    }

    /**
     * Method to open the workout scene
     * @throws IOException
     */
    public void openWorkout() throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("workout.fxml"));
        Stage newAccStage = new Stage();
        Scene scene = new Scene(part);
        newAccStage.setScene(scene);
        newAccStage.setTitle("Kenko");
        newAccStage.show();
    }

    /**
     * Method to open the update progress scene
     * @throws IOException
     */
    public void openUpdateProgress() throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("updateProgress.fxml"));
        Stage newAccStage = new Stage();
        Scene scene = new Scene(part);
        newAccStage.setScene(scene);
        newAccStage.setTitle("Kenko");
        newAccStage.show();
    }
}
