package com.speed.service;

import com.speed.model.Category;
import com.speed.model.ProductFromBarcode;

import javax.ejb.EJB;
import javax.ejb.EJBException;
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
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * Created by ewaw on 24.04.16.
 */
@WebServlet(urlPatterns = "FrontEnd/SearchByBarcode")
@MultipartConfig
public class SearchByBarcodeServlet extends HttpServlet {


    @EJB
    ProductFromBarcodeApp product;

    @EJB
    CategorySearch categorySearch;
    

    final static Logger logger = Logger.getLogger(SearchByBarcodeServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part filePart = request.getPart("barcodeImg");          // Retrieves <input type="file" name="barcodeImg">
        String fileName = filePart.getSubmittedFileName();

        ProductFromBarcode product;
        RequestDispatcher dispatcher;
        try (InputStream fileContent = filePart.getInputStream()) {
            product = this.product.findProduct(this.product.GetBitMap(fileContent));

            List<Category> categories = FindKeyWord(product.getProductName());
            if(categories != null){
                request.setAttribute("result", categories);

                dispatcher = request.getRequestDispatcher("foundCategories.jsp");
                dispatcher.forward(request, response);

            } else{
                request.setAttribute("result", product.getProductName()+" did not result in a category");
                dispatcher = request.getRequestDispatcher("foundFileWithBarcode.jsp");}

        }
        catch (EJBException e){
            request.setAttribute("message", "Nie podales sciezki do pliku");
            dispatcher = request.getRequestDispatcher("searchByBarcode.jsp");
        }
        catch(IOException e){
            request.setAttribute("message", "File could not be read");
            dispatcher = request.getRequestDispatcher("searchByBarcode.jsp");
        }

        dispatcher.forward(request, response);


    }

    public List<Category> FindKeyWord(String productName) {

        Pattern pattern = Pattern.compile("[^a-zA-Z]+");
        String[] result = pattern.split(productName);


        for (String i:result) {
            List<Category> catList = categorySearch.searchCategoryByGivenProduct(i);
            if (!catList.isEmpty()) {
                return catList;
            }
        }

        return null;
    }

}