package com.speed.controller;

import com.speed.model.SearchEvent;
import com.speed.service.ReportService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("/reports")
public class ReportController {

    @Inject
    ReportService service;

    @Context
    UriInfo uriInfo;


    @POST
    @Path("/search")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createSearchLog(@NotNull @Valid SearchEvent event){


        Long id = service.save(event);

        return Response.created(
                uriInfo.getAbsolutePathBuilder().segment("{id}").build(id)
        ).build();
    }

    @GET
    @Path("/search/{id}")
    public SearchEvent getSearchLogElement(@PathParam("id") String id){
        return service.getSearchEventById(Long.valueOf(id));
    }

}
