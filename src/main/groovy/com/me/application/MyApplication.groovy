package com.me.application

//http://jersey.576304.n2.nabble.com/Beware-of-JacksonFeature-in-Jersey-td7581633.html

//import org.glassfish.jersey.jackson.JacksonFeature
import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.server.spring.scope.RequestContextFilter

/**
 * Created by chrislin on 5/7/2014.
 */
class MyApplication extends ResourceConfig{
    public MyApplication() {
        //packages("com.me.resource", "com.me.exceptionmapper", "com.fasterxml.jackson.jaxrs.base")
        //packages("com.fasterxml.jackson.jaxrs.base")
        register(com.me.resource.AuthorResource.class)
        register(com.me.exceptionmapper.MeExceptionMapper.class)

        register(com.fasterxml.jackson.jaxrs.base.JsonMappingExceptionMapper.class)
        register(com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper.class)

        /*
        register(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class)
        register(com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider.class)
        register(com.fasterxml.jackson.jaxrs.json.JsonEndpointConfig.class)
        register(com.fasterxml.jackson.jaxrs.json.JsonMapperConfigurator.class)
        */

/*
        register(com.fasterxml.jackson.jaxrs.base.ProviderBase.class)
*/
        register(RequestContextFilter.class)
        //register(JacksonFeature.class)
    }
}
