package com.speed.SearchByBarcode;

import com.speed.model.Category;
import org.apache.log4j.Logger;

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

/**
 * Created by ewaw on 24.04.16.
 */
@WebServlet(urlPatterns = "FrontEnd/SearchByBarcode")
@MultipartConfig
public class SearchByBarcodeServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(SearchByBarcodeServlet.class);
    private static final String SEARCH_BY_BARCODE_JSP = "searchByBarcode.jsp";
    private static final String FOUND_FILE_WITH_BARCODE_JSP = "foundFileWithBarcode.jsp";
    private static final String FOUND_CATEGORIES_JSP = "foundCategories.jsp";
    private static final String ERROR_MSG_1 = "Nie podales sciezki do pliku";
    private static final String ERROR_MSG_2 = "Niemozliwy odczyt pliku. Sprobuj podac adres nowego pliku";
    private static final String ERROR_MSG_3 = "Jakis blad";
    @EJB
    ProductFromBarcodeApp product;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part filePart = request.getPart("barcodeImg");          // Retrieves <input type="file" name="barcodeImg">
        String fileName = filePart.getSubmittedFileName();

        ProductFromBarcode pfb;
        RequestDispatcher dispatcher;

        try (InputStream fileContent = filePart.getInputStream()) {
            pfb = this.product.findProduct(this.product.GetBitMap(fileContent));

            List<Category> categories = pfb.getProductCategories();
            if (categories != null) {
                request.setAttribute("result", categories);

                dispatcher = request.getRequestDispatcher(FOUND_CATEGORIES_JSP);

            } else {
                request.setAttribute("result", "Dla " + pfb.getProductName() + " nie znaleziono odpowiedniej kategorii.");
                dispatcher = request.getRequestDispatcher(FOUND_FILE_WITH_BARCODE_JSP);
            }
        } catch (EJBException e) {
            request.setAttribute("message", ERROR_MSG_1);
            dispatcher = request.getRequestDispatcher(SEARCH_BY_BARCODE_JSP);
        } catch (IOException e) {
            request.setAttribute("message", ERROR_MSG_2);
            dispatcher = request.getRequestDispatcher(SEARCH_BY_BARCODE_JSP);
        } catch (XMLStreamException e) {
            request.setAttribute("message", ERROR_MSG_3);
            dispatcher = request.getRequestDispatcher(SEARCH_BY_BARCODE_JSP);
        }
        dispatcher.forward(request, response);
    }


}