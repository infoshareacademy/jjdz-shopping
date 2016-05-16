package com.speed.service;

import com.speed.repository.PopularProductRepo;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "FrontEnd/PopularProducts")
public class PopularProductsServlet extends HttpServlet{

    @EJB
    PopularProductRepo popularProductRepo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ReportDTO> popularProduct = popularProductRepo.getPopularProduct();

        req.setAttribute("popularProduct", popularProduct);

        RequestDispatcher dispatcher = req.getRequestDispatcher("popularProducts.jsp");
        dispatcher.forward(req, resp);
    }
}
