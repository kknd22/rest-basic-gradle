package com.me.resttest

import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.server.spring.SpringLifecycleListener
import org.glassfish.jersey.server.spring.scope.RequestContextFilter

/**
 * Created by chrislin on 5/12/2014.
 */

import org.glassfish.jersey.test.JerseyTest
//import org.glassfish.jersey.test.external.ExternalTestContainerFactory
import org.glassfish.jersey.test.spi.TestContainerException
import org.glassfish.jersey.test.spi.TestContainerFactory
import org.junit.Test

import javax.ws.rs.GET
import javax.ws.rs.Path

import static org.junit.Assert.assertEquals

import javax.ws.rs.core.Application;

class DummyTestCase extends JerseyTest{

    @Override
    protected Application configure() {
        new ResourceConfig()
                .register(SpringLifecycleListener.class)
                .register(RequestContextFilter.class)
                .property("contextConfigLocation", "classpath:META-INF/spring/root-context.xml")
                .register(com.me.resource.AuthorResource.class)
    }


    @Test
    public void testGet() throws Exception {
        String r = target().path("/authors").request().get(String.class);
        println r
        //assertEquals(r, "n/a");
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
