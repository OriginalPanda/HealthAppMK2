package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene login, createAccount;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        Parent loginScene = FXMLLoader.load(getClass().getResource("login.fxml"));
        login = new Scene(loginScene, 600, 275);
        window.setTitle("Kenko");


        window.setScene(login);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


