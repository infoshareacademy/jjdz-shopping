package com.speed.model;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.speed.model.UserDataDB;
import com.speed.model.UsersData;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Optional;

@SessionScoped
public class SessionData implements Serializable {

    private UsersData user;
    private OAuth2AccessToken userToken;
    private OAuth20Service OAuth2Service;
    @Inject
    private UserDataDB userDataDB;

    public void logIn(UsersData User, OAuth2AccessToken userToken) {
        this.user = User;
        this.userToken = userToken;
    }

    public void logout() {
        this.user = null;
    }

    public Optional<UsersData> getUser() {
        return user != null ? userDataDB.find(user) : Optional.empty();
    }

//    public  UsersData getLogedInUser(){
//        return userDataDB.find(user);
//    }

    public boolean isLoggedIn() {
        return (userToken!=null);
    }

    public OAuth20Service getOAuth2Service() {
        return OAuth2Service;
    }

    public void setOAuth2Service(OAuth20Service OAuth2Service) {
        this.OAuth2Service = OAuth2Service;
    }

    public OAuth2AccessToken getOAuth2Token() {
        return userToken;
    }
}
