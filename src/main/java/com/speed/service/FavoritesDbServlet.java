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

/**
 * Created by raker on 26.05.16.
 */
@WebServlet(urlPatterns = "FrontEnd/FavoritesDbServlet")
public class FavoritesDbServlet extends HttpServlet{
    final  static Logger logger = Logger.getLogger(ShowSubcategoriesServlet.class);

    @EJB
    CategorySearch categorySearch;

    @EJB
    FavoritesDB favoritesDB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Call FavoritesDbServlet");

        String catId = req.getParameter("categoryId");
        logger.debug("categoryId: " + catId);

        Category categoryById = categorySearch.findCategoryById(Integer.parseInt(catId));
        logger.debug("Found category: " + categoryById);

        favoritesDB.addToFavorites(categoryById);

        req.setAttribute("favorites", favoritesDB.getFavorites());

        RequestDispatcher dispatcher = req.getRequestDispatcher("favorites.jsp");
        dispatcher.forward(req, resp);
    }
}
