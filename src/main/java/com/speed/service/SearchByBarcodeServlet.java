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
import javax.xml.stream.XMLStreamException;
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

    final static Logger logger = Logger.getLogger(SearchByBarcodeServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part filePart = request.getPart("barcodeImg");          // Retrieves <input type="file" name="barcodeImg">
        String fileName = filePart.getSubmittedFileName();

        ProductFromBarcode pfb;
        RequestDispatcher dispatcher;

        try (InputStream fileContent = filePart.getInputStream()) {
            pfb = this.product.findProduct(this.product.GetBitMap(fileContent));

            List<Category> categories = pfb.getProductCategories();
            if(categories != null){
                request.setAttribute("result", categories);

                dispatcher = request.getRequestDispatcher("foundCategories.jsp");

            } else{
                request.setAttribute("result", "Dla " + pfb.getProductName() + " nie znaleziono odpowiedniej kategorii.");
                dispatcher = request.getRequestDispatcher("foundFileWithBarcode.jsp");}
        }
        catch (EJBException e){
            request.setAttribute("message", "Nie podales sciezki do pliku");
            dispatcher = request.getRequestDispatcher("searchByBarcode.jsp");
        }
        catch(IOException e){
            request.setAttribute("message", "Niemozliwy odczyt pliku. Sprobuj podac adres nowego pliku");
            dispatcher = request.getRequestDispatcher("searchByBarcode.jsp");
        } catch (XMLStreamException e) {
            request.setAttribute("message", "Jakis blad");
            dispatcher = request.getRequestDispatcher("searchByBarcode.jsp");
        }
        dispatcher.forward(request, response);
    }


}