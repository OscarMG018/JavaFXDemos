package com.example.ProgressBar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Controler {
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label label;
    @FXML
    private Button button;

    public void increment(){
        if(Math.round(progressBar.getProgress()*100) < 100){
            System.out.println(progressBar.getProgress());
            progressBar.setProgress(progressBar.getProgress() + 0.1);
            label.setText(String.valueOf(Math.round(progressBar.getProgress() * 100)) + "%");
        }
    }
}
