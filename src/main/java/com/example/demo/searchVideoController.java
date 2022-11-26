package com.example.demo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class searchVideoController {

    @FXML
    private ListView searchList;
    @FXML
    private Label VideoFoundStatus;

    @FXML
    private TextField searchBar;

    @FXML
    void searchVideo(ActionEvent event) {
        VideoFoundStatus.setText("");
        searchList.refresh();
        boolean flag=false;
        String VideoName=searchBar.getText();
        if(VideoName!=null){
            for(Video v: Video.videoList){
                if(v.videoName.contains(VideoName)){

                    searchList.getItems().addAll(v.videoName);
                    flag=true;

                }
            }
            if(!flag)VideoFoundStatus.setText("No Video With Such Name");
        }
    }

}




