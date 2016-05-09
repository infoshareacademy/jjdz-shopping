package com.speed.service;

/**
 * Created by slawekskel on 5/6/16.
 */
/*public class CalendarServletSample extends AbstractAuthorizationCodeServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // do stuff
    }

    @Override
    protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
        GenericUrl url = new GenericUrl(req.getRequestURL().toString());
        url.setRawPath("/oauth2callback");
        return url.build();
    }

    @Override
    protected AuthorizationCodeFlow initializeFlow() throws IOException {
        return new GoogleAuthorizationCodeFlow.Builder(
                new NetHttpTransport(), JacksonFactory.getDefaultInstance(),
                "[[ENTER YOUR CLIENT ID]]", "[[ENTER YOUR CLIENT SECRET]]",
                Collections.singleton(CalendarScopes.CALENDAR)).setDataStoreFactory(
                DATA_STORE_FACTORY).setAccessType("offline").build();
    }

    @Override
    protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
        // return user ID
    }
}*/
