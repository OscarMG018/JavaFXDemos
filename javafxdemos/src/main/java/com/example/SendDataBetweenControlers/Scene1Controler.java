package com.example.SendDataBetweenControlers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Parent;

public class Scene1Controler {

    @FXML
    private TextField name;

    public void goToScene2(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene2Controler scene2Controler = fxmlLoader.getController();
        scene2Controler.setName(name.getText());
        new SceneControler().changeScene(event, root);
    }
    
}
