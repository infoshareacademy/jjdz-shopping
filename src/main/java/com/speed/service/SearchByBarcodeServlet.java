package com.speed.service;

import com.speed.model.ProductFromBarcode;

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
import java.util.Objects;
import org.apache.log4j.Logger;

/**
 * Created by ewaw on 24.04.16.
 */
@WebServlet(urlPatterns = "FrontEnd/SearchByBarcode")
@MultipartConfig
public class SearchByBarcodeServlet extends HttpServlet {


    @EJB
    ProductFromBarcodeApp product;


    final static Logger logger = Logger.getLogger(SearchByBarcodeServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part filePart = request.getPart("barcodeImg");          // Retrieves <input type="file" name="barcodeImg">
        String fileName = filePart.getSubmittedFileName();

        if (Objects.equals(fileName, "")) {
            logger.debug("file name: ..." + fileName + "...");
            request.setAttribute("message", "Nie podales sciezki do pliku");

            RequestDispatcher dispatcher = request.getRequestDispatcher("searchByBarcode.jsp");
            dispatcher.forward(request, response);
        } else {

        InputStream fileContent = filePart.getInputStream();
        ProductFromBarcode product = this.product.findProduct(this.product.GetBitMap(fileContent));

        request.setAttribute("result", product.getProductName());

        RequestDispatcher dispatcher = request.getRequestDispatcher("foundFileWithBarcode.jsp");
        dispatcher.forward(request, response);}


    }

}