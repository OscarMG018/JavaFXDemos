package com.example.ListView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.beans.value.ChangeListener;

import java.net.URL;
import java.util.ResourceBundle;

public class Controler implements Initializable {
    @FXML
    private ListView<String> listView;
    @FXML
    private Label label;
    private String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.getItems().addAll(items);
        listView.getSelectionModel().selectedItemProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
            label.setText("Selected Item: " + newValue);
        });
        label.setText("Select an item");
    }
}
