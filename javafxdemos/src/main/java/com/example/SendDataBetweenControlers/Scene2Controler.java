package com.example.SendDataBetweenControlers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2Controler {
    @FXML
    private Label name;

    public void setName(String name) {
        this.name.setText(name);
    }
}
