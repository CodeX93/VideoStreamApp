package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class commentController implements Initializable {
HelloApplication ha=new HelloApplication();
    @FXML
    private ListView<String> commentList;

    @FXML
    private Button backToVideo;

    @FXML
    void backToVideo(ActionEvent event) throws IOException {
    ha.main("viewVideo",event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(Comments c:Comments.commentsArrayList){
            if(c.video.equals(viewVideoController.video))
            commentList.getItems().addAll(c.comment);
        }
    }
}
