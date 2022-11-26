package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ratingController implements Initializable {
HelloApplication ha=new HelloApplication();
    @FXML
    private ComboBox<String> ratingList;
    @FXML
    void submitRate(ActionEvent event) throws IOException {
               String r= ratingList.getItems().toString();
               if(r!=null){
                   Rating rating=new Rating(r,viewVideoController.video);
                   System.out.println(r);
                   Rating.ratingArrayList.add(rating);
                   ha.main("viewVideo",event);
               }
    }

    @FXML
    void rateVid(ActionEvent event) {

    }

    @FXML
    void backToViewVideo(ActionEvent event) throws IOException {
        ha.main("viewVideo",event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ratingList.getItems().addAll("1","2","3","4","5");
    }
}
