package com.example.ExitButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Controler {
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane root;

    @FXML
    private void handleExitButtonAction(ActionEvent event) {
        Main.Logout(root);
    }
}
