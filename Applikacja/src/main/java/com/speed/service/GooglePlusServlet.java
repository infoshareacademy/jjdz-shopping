package com.speed.service;

/**
 * Created by slaw on 14.05.16.
 */

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.speed.model.SessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("FrontEnd/googleplus")
public class GooglePlusServlet extends HttpServlet {


    @Inject
    SessionData sessionData;


    private static Logger logger = LoggerFactory.getLogger(GooglePlusServlet.class);
    private static final String CLIENT_ID = "689901795833-d2plfdd7bki7o94g31v9qce2c2miferk.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "-ffFvv3enMwJSDLRVWtAhREf";



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //String referrer = req.getParameter("referrer");

        logger.debug("Making a service for OAuth.");
        OAuth20Service service = new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback("http://localhost:18080/jjdz-shopping-1.0-SNAPSHOT/FrontEnd/oauth2callback")
                .scope("openid profile email " +
                        "https://www.googleapis.com/auth/plus.login " +
                        "https://www.googleapis.com/auth/plus.me")
                .build(GoogleApi20.instance());

        sessionData.setOAuth2Service(service);
        //resp.sendRedirect(service.getAuthorizationUrl());

        Map<String, String> additionalParams = new HashMap<>(1);
        additionalParams.put("prompt", "select_account");
        resp.sendRedirect(service.getAuthorizationUrl(additionalParams));
    }


    }

