package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class CreateAccountController {
HelloApplication ha=new HelloApplication();
Viewer viewerRef=new Viewer();
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;

    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Label usernameExist;
    @FXML
    private Label passwordMatch;
    @FXML
    private Label enterAllField;

    @FXML
    private TextField userName;
    @FXML
    void returnMainMenu(ActionEvent event) throws IOException {
        ha.main("loginPage",event);
    }

    @FXML
    void createAccount(ActionEvent event) throws IOException {
        //check if entered account already exist
        String FirstName=null, LastName=null, Username=null, Email=null, Password=null, ConfirmPassword=null;
        FirstName = firstName.getText();
        LastName = lastName.getText();
        Username = userName.getText();
        Email = email.getText();
        Password = password.getText();
        ConfirmPassword = confirmPassword.getText();

        if ((!(FirstName.equals("") )) && (!(LastName.equals(""))) && (!(Username.equals(""))) && (!(Email.equals(""))) && (!(Password.equals(""))) && (!(ConfirmPassword.equals("")))) {

            if (Password.equals(ConfirmPassword)) {

                if (viewerRef.alreadyExist(Username)) {
                    System.out.println("Inside");
                    Viewer viewer = new Viewer(FirstName, LastName, Username, Email, Password);

                    viewer.viwerList.add(viewer);
                    ha.main("loginPage",event);
                }
                else {usernameExist.setText("Username already Taken");}     //userName Exist
            } else {passwordMatch.setText("Password Does Not Match");}      //password Does Not Match

        }else {enterAllField.setText("Please Enter All Fields");}           //user haven't filled all the fields
    }

}
