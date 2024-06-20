package com.example.ColorPicker;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;


public class Controler {
    @FXML
    private ColorPicker colorPicker;

    @FXML
    private AnchorPane anchorPane;
    
    public void SetBackground(ActionEvent event){
        anchorPane.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
