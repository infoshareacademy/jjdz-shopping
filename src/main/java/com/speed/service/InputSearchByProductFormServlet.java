package com.speed.service;


import com.speed.model.DataFromSearchByProductForm;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "FrontEnd/SearchByProductServlet")
public class InputSearchByProductFormServlet extends HttpServlet {

    @EJB
    CategorySearch categorySearch;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchedProduct = req.getParameter("searchedProduct");

        String result = categorySearch.searchCategoryByGivenProduct(searchedProduct);
        System.out.println(result);

        req.setAttribute("result", result);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);


    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
//        dispatcher.forward(req, resp);
//    }
}
