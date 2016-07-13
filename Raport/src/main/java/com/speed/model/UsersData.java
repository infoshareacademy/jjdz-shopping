package com.speed.model;


import java.io.Serializable;

/**
 * Created by slaw on 15.05.16.
 */


public class UsersData implements Serializable {

    private String userName;
    private String userEmail;
    private String reportFrequency;
    private String userType;

//    public UsersData(String userName, String userEmail) {
//        this.userName = userName;
//        this.userEmail = userEmail;
//    }

    public UsersData(String userEmail) {
        this.userEmail = userEmail;
    }

    public UsersData() {
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getReportFrequency() {
        return reportFrequency;
    }

    public void setReportFrequency(String reportFrequency) {
        this.reportFrequency = reportFrequency;
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
                ", reportFrequency='" + reportFrequency + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
