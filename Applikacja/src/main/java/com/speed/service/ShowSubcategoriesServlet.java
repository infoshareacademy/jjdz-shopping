package com.speed.service;


import com.speed.model.Category;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "FrontEnd/ShowSubcategoriesServlet")
public class ShowSubcategoriesServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(ShowSubcategoriesServlet.class);
    private static final String CATEGORIES_NOT_FOUND_JSP = "categoriesNotFound.jsp";
    private static final String FOUND_CATEGORIES_JSP = "foundCategories.jsp";

    @EJB
    CategorySearch categorySearch;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Call ShowSubcategoriesServlet");

        String catId = req.getParameter("categoryId");
//        logger.debug("categoryId: " + catId);

        List<Category> result = categorySearch.findCategoryChildren(Integer.parseInt(catId));
        StringBuilder currentPath = categorySearch.showPath(Integer.parseInt(catId));

        req.setAttribute("result", result);
        req.setAttribute("currentPath", currentPath);

        if (result.size() > 0) {
            sentToPage(req, resp, FOUND_CATEGORIES_JSP);
        } else {
            sentToPage(req, resp, CATEGORIES_NOT_FOUND_JSP);
        }
    }

    private void sentToPage(HttpServletRequest req, HttpServletResponse resp, String s) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(s);
        dispatcher.forward(req, resp);
    }
}
