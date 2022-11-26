package com.example.demo;

import java.util.ArrayList;

public class Comments {
public static ArrayList<Comments>commentsArrayList=new ArrayList<>();
    String comment;
    Video video;

    public Comments(String comment, Video video) {
        this.comment = comment;
        this.video = video;
    }
}
