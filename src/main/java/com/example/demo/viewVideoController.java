package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class viewVideoController implements Initializable {
public static Video video;
HelloApplication ha=new HelloApplication();
    @FXML
    private TextArea writeComment;

    @FXML
    private TextArea videoDescription;

    @FXML
    private Label favVideo;

    @FXML
    private Label commentSubmitStatus;

    @FXML
    private Text videoTitle;

    @FXML
    private MediaView videoPlay;

    @FXML
    void initiateRate(ActionEvent event) throws IOException {
    ha.main("rating",event);
    }

    @FXML
    void commentVideo(ActionEvent event) {
        String comment=writeComment.getText();
        if(comment!=null) {
            Comments comments = new Comments(comment, video);
            Comments.commentsArrayList.add(comments);
            commentSubmitStatus.setText("Comment Submitted Successfully");
        }
        }

    @FXML
    void shareVideo(ActionEvent event) throws IOException {
            ha.main("shareScreen",event);
    }

    @FXML
    void viewComments(ActionEvent event) throws IOException {
        ha.main("viewComments",event);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //  ratingList.getItems().addAll(1,2,3,4,5);
        File file = video.videoPath;

        videoTitle.setText(video.videoName);
        if(video.videoDescription!=null)
        videoDescription.setText(video.videoDescription);
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        videoPlay.setMediaPlayer(mediaPlayer);

    }

    @FXML
    void reportVideo(ActionEvent event) throws IOException {
        ReportController.video=video;
        ha.main("ReportVideo",event);

    }


    @FXML
    void backToHome(ActionEvent event) throws IOException {
        ha.main("HomeScreen",event);
    }

    @FXML
    void addToFavourite(ActionEvent event) {
        Video fVideo=new Video(MenuController.activeUser,video.videoName,video.videoDescription,video.videopath,video.videoPath);

            FavouriteVideo fv=new FavouriteVideo(fVideo);
            FavouriteVideo.favouriteVideos.add(fv);
        favVideo.setText("Added");
        System.out.println(video.videoName);
    }






}