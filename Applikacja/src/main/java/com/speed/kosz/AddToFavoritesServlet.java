package com.speed.kosz;

import com.speed.model.Favorites;
import com.speed.service.CategorySearch;
import com.speed.service.ShowSubcategoriesServlet;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "FrontEnd/AddToFavoritesServlet")
public class AddToFavoritesServlet extends HttpServlet {

    final  static Logger logger = Logger.getLogger(ShowSubcategoriesServlet.class);
    private static final String FAVORITES_JSP = "favorites.jsp";

    @EJB
    CategorySearch categorySearch;

    @EJB
    Favorites favorites;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Call AddToFavoritesServlet");

        String catId = req.getParameter("categoryId");
        logger.debug("categoryId: " + catId);

        favorites.addToFavorites(categorySearch.findCategoryById(Integer.parseInt(catId)));

        req.setAttribute("favorites", favorites.getFavorites());

        RequestDispatcher dispatcher = req.getRequestDispatcher(FAVORITES_JSP);
        dispatcher.forward(req, resp);
    }


}
