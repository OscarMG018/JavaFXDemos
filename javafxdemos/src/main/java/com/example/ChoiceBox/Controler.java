package com.example.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class Controler implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox;
    private String[] items = {"Pizza", "Sushi", "Ramen"};

    @FXML
    private Label label;

    public void initialize(URL url, ResourceBundle rb) {
        choiceBox.getItems().addAll(items);
        choiceBox.setOnAction(e->Show(e));
    }

    public void Show(ActionEvent event){
        label.setText(choiceBox.getValue());
    }

}

