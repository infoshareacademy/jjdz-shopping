package com.speed.controller;

import com.speed.model.ReportDTO;
import com.speed.model.SearchEvent;
import com.speed.model.SearchEventEntity;
import com.speed.service.PopularProductsReport;
import com.speed.service.ReportService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ewa on 6/28/16.
 */

@RunWith(Arquillian.class)
public class ReportControllerIT {

    static URI create_event_location;
    SearchEvent event;

    @Deployment
    public static WebArchive create() {

        File libs[] = Maven.resolver()
                .resolve("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.5.4").withTransitivity()
                .asFile();

        return ShrinkWrap.create(WebArchive.class)
                .addAsLibraries(libs)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addClasses(ReportController.class, ReportDTO.class, SearchEvent.class, SearchEventEntity.class, ReportService.class)
                .addClass(PopularProductsReport.class);
    }

    @Before
    public void setup_search_event() {
        // stworzę obiek SearchEvent
        event = new SearchEvent();
        event.setProduct("Rower");
        event.setDate(LocalDate.now());
    }

    @Test
    @RunAsClient
    @InSequence(1)
    public void should_add_new_event(@ArquillianResource URL baseUrl) {
        // post()

        URI uri = UriBuilder.fromUri(baseUrl.toString())
                .segment("api").segment("reports").segment("search").build();

        Response post = ClientBuilder.newClient()
                .target(uri)
                .request()
                .post(Entity.json(event));

        create_event_location = post.getLocation();

        // location: xxxxx
        assertThat(post.getLocation().getPath(), containsString("/reports/search"));
        assertThat(post.getStatus(), is(201));

    }

    @Test
    @RunAsClient
    @InSequence(2)
    public void should_return_an_event(@ArquillianResource URL baseUrl) {
        // get(xxxxx)
        SearchEvent searchEvent = ClientBuilder.newClient()
                .target(create_event_location)
                .request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(SearchEvent.class);

        assertThat(searchEvent.getProduct(), is(event.getProduct()));

    }

}