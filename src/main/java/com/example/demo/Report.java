package com.example.demo;

import java.util.ArrayList;

public class Report {

public static ArrayList<Report>reportsList=new ArrayList<>();
    String ReportDescription;
        Video reportVideo;
    public Report(String reportDescription, Video reportVideo) {
        ReportDescription = reportDescription;
        this.reportVideo = reportVideo;
    }

}
