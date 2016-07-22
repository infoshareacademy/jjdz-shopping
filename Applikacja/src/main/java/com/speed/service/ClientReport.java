package com.speed.service;

import com.speed.model.SearchEvent;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Stateless
public class ClientReport {

    final  static Logger logger = Logger.getLogger(ClientReport.class);

    @EJB
    SearchEventBuffer searchEventBuffer;

    private final String baseUrl = "http://jboss-report:8080/shopping";


    public void sendEvent(SearchEvent searchEvent){

        URI uri = UriBuilder.fromUri(baseUrl)
                .segment("api").segment("reports").segment("search").build();

        URI uriTestConnection = UriBuilder.fromUri(baseUrl)
                .segment("api").segment("reports").segment("popularProducts").build();


        try {

            if(ClientBuilder.newClient().target(uriTestConnection).request().get() != null){

                logger.info("Report is running.................OK");

                if(searchEventBuffer.wasReportAppON() == false){

                    for (SearchEvent bufferSearchEvent:searchEventBuffer.getBuffer()) {

                        SendingReport(uri, bufferSearchEvent);
                    }

                    searchEventBuffer.deleteBuffer();
                    searchEventBuffer.setReportAppON(true);
                }

                SendingReport(uri, searchEvent);
            }

            } catch (Exception e) {

                searchEventBuffer.setBuffer(searchEvent);
                searchEventBuffer.setReportAppON(false);

                logger.error("There is no connection with Report aplication");
                e.printStackTrace();
            }

    }

    public void SendingReport(URI uri, SearchEvent searchEvent){

        Response post = ClientBuilder.newClient()
                .target(uri)
                .request()
                .post(Entity.json(searchEvent));

    }

}
