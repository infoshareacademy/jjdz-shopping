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

/**
 * Created by slawekskel on 5/6/16.
 */

@WebServlet(urlPatterns = "FrontEnd/LogingServlet")
public class LogingServlet extends HttpServlet {

         final  static Logger logger = Logger.getLogger(LogingServlet.class);

        @EJB
        CategorySearch categorySearch;

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            logger.debug("START w servlecie");

            String searchedProduct = req.getParameter("searchedProduct");
            logger.debug("getParameter: " + searchedProduct);

            List<Category> result = categorySearch.searchCategoryByGivenProduct(searchedProduct);

            req.setAttribute("result", result);

            RequestDispatcher dispatcher = req.getRequestDispatcher("foundCategories.jsp");
            dispatcher.forward(req, resp);


        }



}
