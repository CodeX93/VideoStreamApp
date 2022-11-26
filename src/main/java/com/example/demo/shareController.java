package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class shareController implements Initializable {
HelloApplication ha=new HelloApplication();
    @FXML
    private Label sharingLink;

    @FXML
    void backToVIdeo(ActionEvent event) throws IOException {
        ha.main("viewVideo",event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sharingLink.setText(viewVideoController.video.videopath);
    }
}
