package com.example.SendDataBetweenControlers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene1.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Send Data Between Controlers");
        stage.setScene(scene);
        stage.show();
    }
}
