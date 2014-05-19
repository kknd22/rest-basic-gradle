package com.me.exceptionmapper

import com.me.exception.MeRumtineException

import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

/**
 * Created by chrislin on 5/16/2014.
 */
@Provider
class MeExceptionMapper implements ExceptionMapper<MeRumtineException> {

    Response toResponse(MeRumtineException ex) {
        Response.status(404).entity(ex.getMessage()).type("text/plain").build();
    }
}

