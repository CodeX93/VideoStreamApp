package com.example.demo;

import java.util.ArrayList;

public class Viewer {
public static ArrayList<Viewer> viwerList=new ArrayList<>();
public Viewer(){}
    String FirstName;
    String LastName;
    String Username;
    String Email;
    String Password;

    public Viewer(String firstName, String lastName, String username, String email, String password) {
        FirstName = firstName;
        LastName = lastName;
        Username = username;
        Email = email;
        Password = password;
    }
    public boolean alreadyExist(String username){
        boolean flag=true;
        for(Viewer v:viwerList ){
            if(v.Username.equals(username)){
                flag=false;
            }
        }
        return flag;
    }
    public static Viewer getViewer(String email){
        for(Viewer viewer:viwerList){
            if(viewer.Email.equals(email))
                return viewer;
        }
        return null;
    }


}
