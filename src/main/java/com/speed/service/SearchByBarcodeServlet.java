package com.speed.service;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ewaw on 24.04.16.
 */
@WebServlet(urlPatterns = "FrontEnd/SearchByBarcode")
@MultipartConfig
public class SearchByBarcodeServlet extends HttpServlet {

    @EJB
    ProductFromBarcodeApp product;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("barcodeImg");                  // Retrieves <input type="file" name="barcodeImg">
        String fileName = filePart.getSubmittedFileName();
        InputStream fileContent = filePart.getInputStream();

//        product.findProduct(fileName); //co zrobic z plikiem? przesylany jest InputStream...


        request.setAttribute("result", fileName);

        RequestDispatcher dispatcher = request.getRequestDispatcher("foundFileWithBarcode.jsp");
        dispatcher.forward(request, response);


    }

}