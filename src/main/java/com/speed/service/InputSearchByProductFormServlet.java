package com.speed.service;


import com.speed.model.DataFromSearchByProductForm;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "InputSearchByProductForm")
public class InputSearchByProductFormServlet extends HttpServlet {

    @EJB
    CategorySearch categorySearch;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchedProduct = req.getParameter("searchedProduct");



        super.doGet(req, resp);
    }
}
