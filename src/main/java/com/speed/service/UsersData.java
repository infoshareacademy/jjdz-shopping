package com.speed.service;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    @Override
    public String toString() {
        return "UsersData{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
