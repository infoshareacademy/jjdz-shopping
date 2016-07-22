package com.speed.service;


import com.speed.model.Category;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "FrontEnd/SearchByProductServlet")
public class InputSearchByProductFormServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(InputSearchByProductFormServlet.class);
    private static final String FOUND_CATEGORIES_JSP = "foundCategories.jsp";
    private static final String CATEGORIES_NOT_FOUND_JSP = "categoriesNotFound.jsp";
    private static final String SEARCH_BY_PRODUCT_FORM_JSP = "searchByProductForm.jsp";
    private static final String ERROR_MSG_1 = "Nie podales szukanego produktu";

    @EJB
    CategorySearch categorySearch;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        logger.debug("START w servlecie");

        String searchedProduct = req.getParameter("searchedProduct");

        searchedProduct= StringEscapeUtils.unescapeHtml(searchedProduct).replaceAll(";","");


        List<Category> result = categorySearch.searchCategoryByGivenProduct(searchedProduct);
        RequestDispatcher dispatcher;
        req.setAttribute("result", result);

        if (!searchedProduct.equals("")) {
            if (result.size() > 0) {
                dispatcher = req.getRequestDispatcher(FOUND_CATEGORIES_JSP);
            } else {
                dispatcher = req.getRequestDispatcher(CATEGORIES_NOT_FOUND_JSP);
            }
        } else {
            req.setAttribute("message", ERROR_MSG_1);
            dispatcher = req.getRequestDispatcher(SEARCH_BY_PRODUCT_FORM_JSP);
        }
        dispatcher.forward(req, resp);
    }

}
