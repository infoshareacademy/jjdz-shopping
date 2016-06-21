package com.speed.service;

/**
 * Created by slaw on 14.05.16.
 */

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

@WebServlet("FrontEnd/logout")
public class LogoutServlet extends HttpServlet {


    public static final String INDEX_JSP = "index.jsp";
    @Inject
    SessionData sessionData;

    private static Logger logger = LoggerFactory.getLogger(GooglePlusServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //String referrer = req.getParameter("referrer");

        logger.debug("Loging out");

        sessionData.logout();
        resp.sendRedirect(INDEX_JSP);
    }



}
