package com.me.resttest

import com.me.config.shared.MyBean
import com.me.service.AuthorService
import groovy.json.JsonSlurper
import org.glassfish.jersey.server.ResourceConfig

/**
 * Created by chrislin on 5/12/2014.
 */
import org.junit.Test
import org.springframework.context.annotation.Bean

//import org.glassfish.jersey.test.external.ExternalTestContainerFactory
import org.springframework.context.annotation.Configuration

import javax.ws.rs.core.Application
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

import static org.mockito.Mockito.mock
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when
import static org.mockito.Mockito.when

//@ContextConfiguration(classes = [RestSpringConfig.class, SpringConfig.class])
class AuthorResourceTest extends AbstractBaseResourceTest{

    @Override
    protected Application configure(ResourceConfig rc) {
        rc.register(com.me.resource.AuthorResource.class)

    }


    @Test
    public void testGet() throws Exception {
        Response r = target().path("/authors/111").request(MediaType.APPLICATION_JSON_TYPE).get();
        assert r.getStatus() == Response.Status.OK.statusCode

        //String r = target().path("/authors/111").request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

        def s = r.readEntity(String.class)
        def json = new JsonSlurper().parseText(s)
        json.dump()
        assert json.name == 'from-SpringMockConfig-value-MOCKITO'
        assert json.id == 111

    }


/*

    @Override
    protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
        return new ExternalTestContainerFactory();
    }

    @Override
    protected String getResourcePath() {
        return "/api/authors";
    }

*/


/*
    @Path("hello")
    public static class HelloResource {
        @GET
        public String getHello() {
            return "Hello World!";
        }
    }

    @Override
    protected Application configure() {
        return new ResourceConfig(HelloResource.class);
    }

    @Test
    public void test() {
        final String hello = target("hello").request().get(String.class)
        println (hello)
        assertEquals("Hello World!", hello)
    }

*/

}
