package com.speed.service;


import com.speed.dao.CategoryDao;
import com.speed.dao.Dao;
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
import java.util.Map;

@WebServlet(urlPatterns = "FrontEnd/SearchByProductServlet")
public class InputSearchByProductFormServlet extends HttpServlet {

    final  static Logger logger = Logger.getLogger(InputSearchByProductFormServlet.class);

    @EJB
    CategorySearch categorySearch;

    @EJB
    ReportPopularProducts reportPopularProducts;

//    @EJB
//    CategoryDao categoryDao;



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        logger.debug("START w servlecie");

        String searchedProduct = req.getParameter("searchedProduct");
//        logger.debug("getParameter: " + searchedProduct);

        List<Category> result = categorySearch.searchCategoryByGivenProduct(searchedProduct);

        req.setAttribute("result", result);

        if(result.size() > 0){
            RequestDispatcher dispatcher = req.getRequestDispatcher("foundCategories.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("categoriesNotFound.jsp");
            dispatcher.forward(req, resp);
        }




    }
}
