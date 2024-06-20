package com.example.ChangeScene;


import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.*;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Change Scene");
        stage.show();
    }
}
