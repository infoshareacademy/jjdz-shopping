package com.speed.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by slaw on 15.05.16.
 */



public class UsersData implements Serializable{

    private String userName;
    private String userEmail;


    public UsersData(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public UsersData(String userEmail) {
        this.userEmail = userEmail;
    }

    public UsersData() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
