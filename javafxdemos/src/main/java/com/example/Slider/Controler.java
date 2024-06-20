package com.example.Slider;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.beans.value.ChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

public class Controler implements Initializable {
    @FXML
    private Slider slider;
    @FXML
    private Label label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        slider.valueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> {Show();});
    }

    public void Show(){
        label.setText(String.valueOf(Math.round(slider.getValue())) + " °C");
    }
}
