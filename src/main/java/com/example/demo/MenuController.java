package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class MenuController {
HelloApplication ha=new HelloApplication();
  static Viewer activeUser;

    @FXML
    private PasswordField password;
    @FXML
    private TextField username;

    @FXML
    void login(ActionEvent event) throws IOException {
        //Credential checks goes here...
        if(username.getText().equals("admin") && password.getText().equals("admin")){
            ha.main("viewReportVideo",event);

        }else {
            for (Viewer v : Viewer.viwerList) {

                if (v.Username.equals(username.getText()) && v.Password.equals(password.getText())) {
                    activeUser=v;
                    ha.main("HomeScreen", event);
                }
            }
        }
        }
    @FXML
    void createUserAccount(ActionEvent event) throws IOException {
            ha.main("createaccount",event);
    }



}
