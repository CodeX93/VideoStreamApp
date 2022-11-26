package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;


public class uploadVideoController {
HelloApplication ha=new HelloApplication();
    @FXML
    private Text attachStatus;
    @FXML
    private TextArea videoDescription;
     @FXML
    private TextField videoTitle;
    @FXML
    private Label videoPath;
//---------------------------------------------------------------------------------------
    @FXML
    void uploadVideo( ActionEvent event) throws IOException {
        Viewer user;
        String VIDPATH, VidTitle,VidPath,VidDescription;
           if(!videoTitle.equals("")){
               if(!attachStatus.getText().equals("No Video Selected")){
                   //insertVideo Object to Video Collection
                   user=MenuController.activeUser;
                   VidTitle=videoTitle.getText();
                   VidPath=videoPath.getText();
                   VIDPATH=videoPath.getText();
                   VidDescription=videoDescription.getText();
                   File f=new File(VidPath);
                   System.out.println(user.Email);
                   Video v=new Video(user,VidTitle,VidDescription,VIDPATH,f);
                   Video.videoList.add(v);
                  //System.out.println(user.FirstName+" "+user.LastName);
                   ha.main("HomeScreen",event);
               }else {  attachStatus.setText("Please Select Video");     }
           }else{   videoTitle.setText("Please Enter the Video Title");  }
    }

    @FXML
    void HomeScreen(ActionEvent event) throws IOException {
        ha.main("HomeScreen",event);
    }

    @FXML
    void attachVideo(ActionEvent event) {
        FileChooser uploadVideo=new FileChooser();
        uploadVideo.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("mp4 files","*.mp4"));
        File selectedVideo= uploadVideo.showOpenDialog(null);
        if(selectedVideo!=null){

            attachStatus.setText(selectedVideo.getName()+" is selected");
            videoPath.setText(selectedVideo.getPath());

        }
    }



}
