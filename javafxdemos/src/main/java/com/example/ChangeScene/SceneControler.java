package com.example.ChangeScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;

public class SceneControler {
    public void changeScene(ActionEvent event, String sceneName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneName + ".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buttonSceneEvent(ActionEvent event) {
        String FxId = ((Button) event.getSource()).getId(); //Button<SceneName>
        String sceneName = FxId.substring(6); //SceneName 
        changeScene(event, sceneName);
    }
}
