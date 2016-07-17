package com.speed.service;

import com.speed.model.UsersData;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "FrontEnd/AllUsersData")
public class AllUsersDataServlet extends HttpServlet {

    private final static String ADMIN_PANEL = "adminPanel.jsp";

    @EJB
    AllUsersDbService allUsersDbService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String receivedUserEmail = req.getParameter("userEmail");
        String userType = allUsersDbService.userTypeByEmail(receivedUserEmail).get(0).getUserType();

        if(userType.equals("1")){
            List<UsersData> allUsers = allUsersDbService.allUsersData();
            req.setAttribute("receivedUserEmail", receivedUserEmail);
            req.setAttribute("allUsers", allUsers);

            RequestDispatcher dispatcher = req.getRequestDispatcher(ADMIN_PANEL);
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher(ADMIN_PANEL);
            dispatcher.forward(req, resp);
        }

    }
}
