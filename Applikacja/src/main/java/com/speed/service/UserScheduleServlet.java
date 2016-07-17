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

@WebServlet(urlPatterns = "FrontEnd/UserScheduleUpdate")
public class UserScheduleServlet extends HttpServlet {

    private final static String REPORT_SCHEDULE = "index.jsp";

    @EJB
    ScheduleDbService scheduleDbService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userScheduleParam = req.getParameter("userScheduleParam");
        String userEmail = req.getParameter("userEmail");

        scheduleDbService.updateUserReportSchedule(userScheduleParam, userEmail);

        RequestDispatcher dispatcher = req.getRequestDispatcher(REPORT_SCHEDULE);
        dispatcher.forward(req, resp);

    }
}
