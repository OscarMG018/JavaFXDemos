package com.example.DatePicker;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import java.time.format.DateTimeFormatter;

public class Controler {
    @FXML
    private DatePicker datePicker;
    @FXML
    private Label label;
    private String format = "dd-MM-yyyy";

    public void Show(ActionEvent event){
        label.setText(datePicker.getValue().format(DateTimeFormatter.ofPattern(format)));
    }
}
