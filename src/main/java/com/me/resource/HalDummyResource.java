package com.me.resource;

import com.me.dto.HalDummy;
import  com.sun.jersey.spi.container.servlet.ServletContainer;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by chrislin on 5/5/2014.
 */
@Path("/hal")
@Component
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class HalDummyResource {

    /**
     *
     * @param id
     * @return
     */
    @Path("{id}")
    @GET
    public Response getDummy(@PathParam("id") Integer id) {
        System.out.println ("id is: " + id);
        HalDummy h = new HalDummy(id, "dummy stuff");
        return Response.ok().entity(h).build();
    }


}
