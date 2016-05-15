package com.speed.service;

import javax.persistence.Entity;

/**
 * Created by slaw on 15.05.16.
 */

@Entity
public class UsersData {

    public UsersData(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    private String userName;
    private String userEmail;



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
