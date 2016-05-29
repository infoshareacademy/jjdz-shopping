package com.speed.service;

import com.speed.model.Category;
import com.speed.model.FavoritesDB;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class FavoritesDbServlet extends HttpServlet{

    @EJB
    CategorySearch categorySearch;

    @EJB
    FavoritesDB favoritesDB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Call FavoritesDbServlet");

        String catId = req.getParameter("categoryId");
        log.debug("categoryId: " + catId);

        Category categoryById = categorySearch.findCategoryById(Integer.parseInt(catId));
        log.debug("Found category: " + categoryById);

        favoritesDB.addToFavorites(categoryById);

        req.setAttribute("favorites", favoritesDB.getFavorites());

        RequestDispatcher dispatcher = req.getRequestDispatcher("favorites.jsp");
        dispatcher.forward(req, resp);
    }
}
