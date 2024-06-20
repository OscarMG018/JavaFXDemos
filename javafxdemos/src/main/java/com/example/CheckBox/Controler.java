package com.example.CheckBox;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class Controler {
    @FXML
    private CheckBox checkBox;
    @FXML
    private Label label;
    @FXML
    private ImageView imageView;

    private Image On = new Image(getClass().getResource("images/on.png").toExternalForm());
    private Image Off = new Image(getClass().getResource("images/off.png").toExternalForm());

    public void Switch(){
        if(checkBox.isSelected()){
            imageView.setImage(On);
            label.setText("ON");
        }else{
            imageView.setImage(Off);
            label.setText("OFF");
        }
    }

}

