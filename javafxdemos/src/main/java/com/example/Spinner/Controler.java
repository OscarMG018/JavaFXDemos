package com.example.Spinner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.beans.value.ChangeListener;

import java.net.URL;
import java.util.ResourceBundle;

public class Controler implements Initializable {
    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private Label label;

    public void initialize(URL url, ResourceBundle rb) {
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 50));
        spinner.valueProperty().addListener((ChangeListener<Integer>) (observable, oldValue, newValue) -> {
            label.setText("Value: " + newValue);
        });
        label.setText("Value: " + spinner.getValue());
    }
}

