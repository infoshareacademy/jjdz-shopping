package com.speed.service;

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
//    @EJB
//    PopularProductRepo popularProductRepo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        List<ReportDTO> popularProduct = popularProductRepo.getPopularProduct();
//TODO popularProduct musi tu być pobrany z modułu raportowego
//        req.setAttribute("popularProduct", popularProduct);

        RequestDispatcher dispatcher = req.getRequestDispatcher(POPULAR_PRODUCTS_JSP);
        dispatcher.forward(req, resp);
    }
}
