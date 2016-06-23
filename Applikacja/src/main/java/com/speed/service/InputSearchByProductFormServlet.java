package com.speed.service;


import com.speed.model.Category;
import com.speed.model.ReportPopularProducts;
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

@WebServlet(urlPatterns = "FrontEnd/SearchByProductServlet")
public class InputSearchByProductFormServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(InputSearchByProductFormServlet.class);
    public static final String FOUND_CATEGORIES_JSP = "foundCategories.jsp";
    public static final String CATEGORIES_NOT_FOUND_JSP = "categoriesNotFound.jsp";

    @EJB
    CategorySearch categorySearch;

    @EJB
    ReportPopularProducts reportPopularProducts;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        logger.debug("START w servlecie");

        String searchedProduct = req.getParameter("searchedProduct");
//        logger.debug("getParameter: " + searchedProduct);

        List<Category> result = categorySearch.searchCategoryByGivenProduct(searchedProduct);

        req.setAttribute("result", result);

        if (result.size() > 0) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(FOUND_CATEGORIES_JSP);
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher(CATEGORIES_NOT_FOUND_JSP);
            dispatcher.forward(req, resp);
        }


    }
}