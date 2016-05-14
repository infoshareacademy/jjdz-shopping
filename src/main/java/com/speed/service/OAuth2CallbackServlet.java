package com.speed.service;

/**
 * Created by slaw on 14.05.16.
 */
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        GetUserInfo getUserInfo = new GetUserInfo(req);

        getUserInfo.setSession();
        //RequestDispatcher dispatcher = req.getRequestDispatcher("/");

        resp.sendRedirect("index.jsp");
        //dispatcher.forward(req, resp);


    }
}

class GetUserInfo {
    private static Logger logger = LoggerFactory.getLogger(GetUserInfo.class);

    private HttpServletRequest req;

    public GetUserInfo(HttpServletRequest req) {
        this.req = req;
    }

    public void setSession() {

        Long threadId = Thread.currentThread().getId();
        logger.debug("Getting user information for thread: {} - start", threadId);

        HttpSession session = req.getSession();
        OAuth20Service service = (OAuth20Service) session.getAttribute("oauth2Service");

        logger.debug("Getting the authorization code for thread: {} ", threadId);
        String code = req.getParameter("code");
        logger.debug("Constructing the access token for thread: {} ", threadId);
        OAuth2AccessToken token = service.getAccessToken(code);
        session.setAttribute("token", token);

        logger.debug("Getting the user's G+ profile for thread: {} ", threadId);
        OAuthRequest oReq = new OAuthRequest(Verb.GET,
                "https://www.googleapis.com/oauth2/v2/userinfo",
                service);
        service.signRequest(token, oReq);
        Response oResp = oReq.send();

        logger.debug("Getting result and saving to session for thread: {} ", threadId);
        JsonReader reader = Json.createReader(new ByteArrayInputStream(
                oResp.getBody().getBytes()));
        JsonObject profile = reader.readObject();

        session.setAttribute("name", profile.getString("name"));
        session.setAttribute("email", profile.getString("email"));
        logger.debug("User information [name:{}, email:{}] acquired for thread: {} - end",session.getAttribute("name") , session.getAttribute("email"), threadId);

        //session.getAttribute("name");


    }
}


