package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class ReportController {
    static Video video;
    HelloApplication ha=new HelloApplication();

    @FXML
    private TextArea reportDetail;
    @FXML
    private Label submitReportMessage;
    @FXML
    private ListView reportList;



    @FXML
    void submitReport(ActionEvent event) throws IOException {
        if (reportDetail.getText() == null) {
            submitReportMessage.setText("Please Enter Report First");
        } else {
            String description = reportDetail.getText();


            Report rep = new Report(description, video);
            Report.reportsList.add(rep);
            ha.main("viewvideo", event);
        }
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        ha.main("loginPage",event);
    }
    @FXML
    void initialize() {
        for(Report r: Report.reportsList) {

            reportList.getItems().addAll("Video Title: "+r.reportVideo.videoName+" Report Description"+r.ReportDescription);
        }
    }









    @FXML
    void backToHome(ActionEvent event) throws IOException {
        ha.main("viewVideo",event);
    }





}