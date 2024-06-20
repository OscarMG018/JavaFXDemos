package com.example.SendDataBetweenControlers;

import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.stage.*;

public class SceneControler {
    public void changeScene(ActionEvent event, Parent sceneRoot) {
        try {
            Scene scene = new Scene(sceneRoot);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
