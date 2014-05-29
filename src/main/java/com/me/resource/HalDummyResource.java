package com.me.resource;

import com.me.dto.HalDummy;
import com.me.exception.MeRumtineException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Api(value = "/hal", description = "HAL resources' API")
public class HalDummyResource {

    /**
     *
     * @param id
     * @return
     */
    @Path("{id}")
    @GET
    @ApiOperation(value = "Retrieve hal using id", notes = "use 111 test for success, 222 for 500 response and others for 404 response", response = HalDummy.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404 , message = "Not Found")})
    public Response getDummy(@PathParam("id") Integer id) throws Exception {
        System.out.println ("id is: " + id);
        HalDummy h = new HalDummy(id, "dummy stuff v1");
        Response.ResponseBuilder r = Response.ok(h);
        if (1==2) {
            throw new MeRumtineException("MeRuntimeException Throwed message#################");
        }
        return r.build();
/*
        return Response.ok().
                link("http://oracle.com", "parent").
                link(new URI("http://jersey.java.net"), "framework").
                build();
*/
    }

    @Path("abc")
    @POST
    Response createHal(HalDummy h) {
        return Response.created(null).build();
    }


}
