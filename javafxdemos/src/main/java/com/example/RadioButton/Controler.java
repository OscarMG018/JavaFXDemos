package com.example.RadioButton;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.event.ActionEvent;

public class Controler {
    @FXML
    private ToggleGroup toggleGroup;
    @FXML
    private Label label;

    public void Change(ActionEvent event){
        label.setText(((RadioButton)toggleGroup.getSelectedToggle()).getText());
    }
}
