package com.example.ImageView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.util.ArrayList;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;
import javafx.event.ActionEvent;

public class Controler implements Initializable {
    
    @FXML
    private Button next;
    @FXML
    private Button prev;

    @FXML
    private ImageView imageView;

    private ArrayList<Image> images;
    private int index;

    public void initialize(URL url, ResourceBundle rb) {
        images = new ArrayList<>();
        File folder = new File(getClass().getResource("").getPath() + "\\images");
        for(File file : folder.listFiles()){
            if(file.isFile() && (file.getName().endsWith(".png") || file.getName().endsWith(".jpg"))){
                images.add(new Image("file:" + file.getAbsolutePath()));
            }
        }
        index = 0;
        imageView.setImage(images.get(index));
    }

    public void Next(ActionEvent e){
        index++;
        if(index >= images.size()){
            index = 0;
        }
        imageView.setImage(images.get(index));
    }

    public void Prev(ActionEvent e){
        index--;
        if(index < 0){
            index = images.size() - 1;
        }
        imageView.setImage(images.get(index));
    }


}
