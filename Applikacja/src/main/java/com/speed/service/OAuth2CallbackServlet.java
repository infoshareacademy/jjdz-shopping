package com.speed.service;

/**
 * Created by slaw on 14.05.16.
 */
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.speed.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "FrontEnd/oauth2callback", asyncSupported=true)
public class OAuth2CallbackServlet extends HttpServlet {
    public static final String GOOGLEAPIS_USERINFO = "https://www.googleapis.com/oauth2/v2/userinfo";
    public static final String INDEX_JSP = "index.jsp";
    public static final String  REPORT_FREQUENCY_DEFAULT = "0";
    public static final String USER_TYPE_DEFAULT = "0";


    private static Logger logger = LoggerFactory.getLogger(OAuth2CallbackServlet.class);

    @Inject
    SessionData sessionData;

    @EJB
    UserDataDB userDataDB;

    @EJB
    TempFavoriteCategoryDbService tempFavoriteCategoryDbService;

    @EJB
    FavoritesDB favoritesDB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        logger.debug("Checking if user consented");
        String error = req.getParameter("error");
        if ((null != error) && ("access_denied".equals(error.trim()))) {
            HttpSession session = req.getSession();
            session.invalidate();
            resp.sendRedirect(req.getContextPath());
            return;
        }

        logger.debug("OK the user have consented so lets find out about the user");

        OAuth20Service oAuth2Service = sessionData.getOAuth2Service();
        String code = req.getParameter("code");
        OAuth2AccessToken token = oAuth2Service.getAccessToken(code);

        OAuthRequest oReq = new OAuthRequest(Verb.GET,
                GOOGLEAPIS_USERINFO,
                oAuth2Service);
        oAuth2Service.signRequest(token, oReq);
        Response oResp = oReq.send();

        JsonReader reader = Json.createReader(new ByteArrayInputStream(
                oResp.getBody().getBytes()));
        JsonObject profile = reader.readObject();

        UsersData user = new UsersData(profile.getString("name"),profile.getString("email"),REPORT_FREQUENCY_DEFAULT, USER_TYPE_DEFAULT);

        UsersData foundUser = userDataDB.findOrSave(user);

        logger.debug("user information [name:{}, email:{}] token: {} - end",profile.getString("name"),profile.getString("email"), token);
        sessionData.logIn(foundUser, token);

        // sprawdzenie tempFavDB czy są jakies wpisy. Jak tak to dodaje użytkownikowi po zalogowaniu
        List<TempFavoriteCategory> tempFavoriteCategories = tempFavoriteCategoryDbService.getTempFavoriteCategory();
        if(!tempFavoriteCategories.isEmpty()){

            // konwersja z tempFavoriteCategories na category
            Category category = new Category();

            category.setCatId(tempFavoriteCategories.get(0).getCatId());
            category.setCatName(tempFavoriteCategories.get(0).getCatName());
            category.setCatParent(tempFavoriteCategories.get(0).getCatParent());
            category.setCatPosition(tempFavoriteCategories.get(0).getCatPosition());
            category.setCatIsProductCatalogueEnabled(tempFavoriteCategories.get(0).getCatIsProductCatalogueEnabled());

            try {
                favoritesDB.addToFavorites(category);
                tempFavoriteCategoryDbService.cleanTempFavoriteDB();
            } catch (UserNotAuthorisedExeption userNotAuthorisedExeption) {
                userNotAuthorisedExeption.printStackTrace();
            }
        }

        resp.sendRedirect(INDEX_JSP);
    }
}

