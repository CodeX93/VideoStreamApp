package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        DBHandler.connectDB();
        pullDataFromDatabase();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stage.setTitle("Login!");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            System.out.println("Stage is closing");//////////////////
            // Save file
            pushAllDataIntoDatabase();

        });
    }
    public void pullDataFromDatabase(){
        Viewer.viwerList= DBHandler.getAllViewers();
        Video.videoList=DBHandler.getAllVideos();
        FavouriteVideo.favouriteVideos=DBHandler.getAllFavouriteVideos();
        Rating.ratingArrayList=DBHandler.getAllRatings();
        Comments.commentsArrayList=DBHandler.getAllComments();

        DBHandler.deleteAllViewers();
        DBHandler.deleteAllVideos();
        DBHandler.deleteAllFavouriteVideos();
        DBHandler.deleteAllRatings();
        DBHandler.deleteAllComments();
    }

    public static void pushAllDataIntoDatabase(){
        DBHandler.insertViewers(Viewer.viwerList);
        DBHandler.insertVideos(Video.videoList);
        DBHandler.insertFavouriteVideos(FavouriteVideo.favouriteVideos);
        DBHandler.insertRatings(Rating.ratingArrayList);
        DBHandler.insertComments(Comments.commentsArrayList);


    }
    public static void main(String fxmlPath,ActionEvent event) throws IOException {
        DBHandler.connectDB();

        //launch();
if(fxmlPath==null){fxmlPath="loginPage";}

        Parent root = FXMLLoader.load(HelloApplication.class.getResource(fxmlPath+".fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }
}