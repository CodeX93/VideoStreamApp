package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    HelloApplication ha = new HelloApplication();
    String videoName;

    @FXML
    private ListView videoList;


    @FXML
    void initialize() {
        for (Video v : Video.videoList) {

            videoList.getItems().addAll(v.videoName);
        }
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        ha.main("loginPage", event);
    }

    @FXML
    void uploadVideo(ActionEvent event) throws IOException {
        ha.main("uploadvideo", event);
    }


    @FXML
    void viewFavouriteVideo(ActionEvent event) throws IOException {

        ha.main("viewMyFav", event);
    }


    @FXML
    void searchVideo(ActionEvent event) throws IOException {
        ha.main("searchVideo", event);

    }

    public void viewVideo() throws IOException {

        videoList.setOnMouseClicked(event -> {
            try {
                String Selected = videoList.getSelectionModel().getSelectedItem().toString();
                Boolean flg = false;
                for (Video v : Video.videoList) {
                    if (v.videoName.equals(Selected)) {
                        viewVideoController.video = v;
                        flg = true;
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewvideo.fxml"));
                        Parent root = loader.load();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();

            }

        });
    }
}




