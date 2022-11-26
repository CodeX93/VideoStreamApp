package com.example.demo;

import java.io.File;
import java.util.ArrayList;

public class Video {
public static ArrayList<Video>videoList=new ArrayList<>();
  Viewer user;
    String videoName, videoDescription;
    File videoPath;
    String videopath;


    public Video(Viewer user,String videoName, String videoDescription, String videopath,File videoPath) {
        this.user=user;
        this.videoName = videoName;
        this.videoDescription = videoDescription;
        this.videoPath = videoPath;
        this.videopath=videopath;

    }

    public static Video getVideo(String VideoPath){
        for(Video video:videoList){
            if(video.videopath.equals(VideoPath))
                return video;
        }
        return null;
    }







}
