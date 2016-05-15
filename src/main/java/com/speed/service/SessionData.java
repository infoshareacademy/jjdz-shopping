package com.speed.service;

import com.github.scribejava.core.model.OAuth2AccessToken;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class SessionData implements Serializable {

    private String userName;
    private String userEmail;
    private OAuth2AccessToken userToken;

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }



    public void logIn(UsersData User, OAuth2AccessToken userToken) {

        this.userEmail = User.getUserEmail();
        this.userName = User.getUserName();
        this.userToken = userToken;
    }

    public void logout() {

        this.userEmail = null;
        this.userName = null;
    }

    public boolean isLoggedIn() {
        return (userToken!=null);
    }

}
