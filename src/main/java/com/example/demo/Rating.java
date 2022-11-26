package com.example.demo;

import java.util.ArrayList;

public class Rating {
static ArrayList<Rating>ratingArrayList=new ArrayList<>();
    public Rating(String rating, Video video) {
        this.rating = rating;
        this.video = video;
    }

    String rating;
    Video video;

}
