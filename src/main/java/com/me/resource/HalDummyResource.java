package com.me.resource;

import com.me.dto.HalDummy;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by chrislin on 5/5/2014.
 */
@Path("/hal")
@Component
@Produces({MediaType.APPLICATION_JSON, "application/vnd.musicstore.v1+json"})
@Consumes({MediaType.APPLICATION_JSON, "application/vnd.musicstore.v1+json"})
public class HalDummyResource {

    /**
     *
     * @param id
     * @return
     */
    @Path("{id}")
    @GET
    public Response getDummy(@PathParam("id") Integer id) throws Exception {
        System.out.println ("id is: " + id);
        HalDummy h = new HalDummy(id, "dummy stuff v1");
        return Response.ok(h).link("/"+id, "self").build();
/*
        return Response.ok().
                link("http://oracle.com", "parent").
                link(new URI("http://jersey.java.net"), "framework").
                build();
*/
    }


}
