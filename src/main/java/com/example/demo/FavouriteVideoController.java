package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;


import java.io.IOException;

public class FavouriteVideoController {
HelloApplication ha=new HelloApplication();


    @FXML
    private ListView favouriteList;

    @FXML
    void backToHome(ActionEvent event) throws IOException {
        ha.main("HomeScreen",event);
    }
    @FXML
    void initialize() {
        for(FavouriteVideo fv: FavouriteVideo.favouriteVideos) {

            favouriteList.getItems().addAll(fv.favouriteVideo.videoName);
        }
    }



}
