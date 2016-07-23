package com.speed.kosz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "FrontEnd/PopularProducts")
public class PopularProductsServlet extends HttpServlet{

    public static final String POPULAR_PRODUCTS_JSP = "popularProducts.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(POPULAR_PRODUCTS_JSP);
        dispatcher.forward(req, resp);
    }
}
