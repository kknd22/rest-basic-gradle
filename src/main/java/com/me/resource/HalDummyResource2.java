package com.me.resource;

import com.me.dto.HalDummy;
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

@Produces({"application/vnd.musicstore.v2+json"})
@Consumes({"application/vnd.musicstore.v2+json"})
public class HalDummyResource2 {

    /**
     *
     * @param id
     * @return
     */
    @Path("{id}")
    @GET
    public Response getDummy(@PathParam("id") Integer id) throws Exception {
        System.out.println ("id is: " + id);
        HalDummy h = new HalDummy(id, "dummy stuff v2");
        return null;
        //return Response.ok(h).link("/"+id, "self").build();
/*
        return Response.ok().
                link("http://oracle.com", "parent").
                link(new URI("http://jersey.java.net"), "framework").
                build();
*/
    }


}
