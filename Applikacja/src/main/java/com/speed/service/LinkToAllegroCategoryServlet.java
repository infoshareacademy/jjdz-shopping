package com.speed.service;

import com.speed.model.Category;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "FrontEnd/LinkToAllegroCategory")
public class LinkToAllegroCategoryServlet extends HttpServlet{

    public static final String ALLEGRO_PL = "http://allegro.pl/";
    @EJB
    CategorySearch categorySearch;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String catId = req.getParameter("categoryId");
        String linkToAllegroCategory = generateCategoryLinkInAllegro(catId);

        req.setAttribute("linkToAllegroCategory", linkToAllegroCategory);

        resp.sendRedirect(linkToAllegroCategory);
    }

    public String generateCategoryLinkInAllegro(String catId){

        String categoryLinkInAllegro = "";
        Category category = categorySearch.findCategoryById(Integer.parseInt(catId));

        if(category.getCatParent() == 0){
            categoryLinkInAllegro = ALLEGRO_PL +
                    category.getCatName().toLowerCase().replace(" ","-").replace("(","").replace(")","") +
                    "?ref=simplified-category-tree";
        } else {
            categoryLinkInAllegro = ALLEGRO_PL +
                    category.getCatName().toLowerCase().replace(" ","-").replace("(","").replace(")","") +
                    "-" +
                    category.getCatId();
        }

        return categoryLinkInAllegro;
    }
}
