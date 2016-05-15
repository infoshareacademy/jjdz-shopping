package com.speed.service;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class SessionData implements Serializable {

    private UsersData user;
    private OAuth2AccessToken userToken;
    private OAuth20Service OAuth2Service;

    public void logIn(UsersData User, OAuth2AccessToken userToken) {
        this.user = User;
        this.userToken = userToken;
    }

    public void logout() {
        this.user = null;
    }

    public UsersData getUser() {
        return user;
    }

    public boolean isLoggedIn() {
        return (userToken!=null);
    }

    public void setOAuth2Service(OAuth20Service OAuth2Service) {
        this.OAuth2Service = OAuth2Service;
    }

    public OAuth20Service getOAuth2Service() {
        return OAuth2Service;
    }

    public OAuth2AccessToken getOAuth2Token() {
        return userToken;
    }
}
