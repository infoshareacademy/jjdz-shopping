package com.speed.service;

import com.speed.model.Category;
import com.speed.model.FavoritesDB;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "FrontEnd/ShowLoggedUserFavoritesServlet")
public class ShowLoggedUserFavoritesServlet extends HttpServlet{
    final  static Logger logger = Logger.getLogger(ShowSubcategoriesServlet.class);
    public static final String LOGING_FORM_JSP = "LogingForm.jsp";
    public static final String FAVORITES_JSP = "favorites.jsp";

    RequestDispatcher dispatcher;

    @EJB
    CategorySearch categorySearch;

    @EJB
    FavoritesDB favoritesDB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Call ShowLoggedUserFavoritesServlet");

        try {
            req.setAttribute("favorites", favoritesDB.getFavorites());
        } catch (UserNotAuthorisedExeption userNotAuthorisedExeption) {
            dispatcher = req.getRequestDispatcher(LOGING_FORM_JSP);
        }
        dispatcher = req.getRequestDispatcher(FAVORITES_JSP);
        dispatcher.forward(req, resp);
    }
}
