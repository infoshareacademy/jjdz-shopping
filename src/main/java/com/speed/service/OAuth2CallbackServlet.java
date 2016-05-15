package com.speed.service;

/**
 * Created by slaw on 14.05.16.
 */
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.UserDataHandler;

import javax.inject.Inject;
import javax.inject.Scope;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "FrontEnd/oauth2callback", asyncSupported=true)
public class OAuth2CallbackServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(OAuth2CallbackServlet.class);

    @Inject
    SessionData sessionData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        logger.debug("Checking if user consented");
        String error = req.getParameter("error");
        if ((null != error) && ("access_denied".equals(error.trim()))) {
            HttpSession session = req.getSession();
            session.invalidate();
            resp.sendRedirect(req.getContextPath());
            return;
        }

        logger.debug("OK the user have consented so lets find out about the user");

        OAuth20Service oAuth2Service = sessionData.getOAuth2Service();
        String code = req.getParameter("code");
        OAuth2AccessToken token = oAuth2Service.getAccessToken(code);

        OAuthRequest oReq = new OAuthRequest(Verb.GET,
                "https://www.googleapis.com/oauth2/v2/userinfo",
                oAuth2Service);
        oAuth2Service.signRequest(token, oReq);
        Response oResp = oReq.send();

        JsonReader reader = Json.createReader(new ByteArrayInputStream(
                oResp.getBody().getBytes()));
        JsonObject profile = reader.readObject();

        UsersData User = new UsersData(profile.getString("name"),profile.getString("email"));
        logger.debug("User information [name:{}, email:{}] token: {} - end",profile.getString("name"),profile.getString("email"), token);
        sessionData.logIn(User, token);


        resp.sendRedirect("index.jsp");
    }
}

