package com.me.application

//http://jersey.576304.n2.nabble.com/Beware-of-JacksonFeature-in-Jersey-td7581633.html
//https://access.redhat.com/site/solutions/375893
/**
 * Root Cause
 * When using the param com.sun.jersey.config.property.packages to set a package to be scanned
 * for JAX-RS resources, there's a Jersey bug which is that it can't scan some JBoss URI schemas
 * such as vfs:.
 */

//import org.glassfish.jersey.jackson.JacksonFeature
import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.server.spring.scope.RequestContextFilter

/**
 * Created by chrislin on 5/7/2014.
 */
class MyApplication extends ResourceConfig{
    public MyApplication() {
        //packages("com.me.resource", "com.me.exceptionmapper", "com.fasterxml.jackson.jaxrs.base")
        register(com.me.resource.AuthorResource.class)
        register(com.me.resource.HalDummyResource.class)
        register(com.me.resource.HalDummyResource2.class)
        register(com.me.exceptionmapper.MeExceptionMapper.class)

        register(com.fasterxml.jackson.jaxrs.base.JsonMappingExceptionMapper.class)
        register(com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper.class)

/*

        register(com.wordnik.swagger.jaxrs.JaxrsApiReader.class)
        register(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class)
        register(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class)
        register(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class)
        register(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class)

*/


        /*
register(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class)
register(com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider.class)
register(com.fasterxml.jackson.jaxrs.json.JsonEndpointConfig.class)
register(com.fasterxml.jackson.jaxrs.json.JsonMapperConfigurator.class)
*/

        register(RequestContextFilter.class)
        //register(JacksonFeature.class)
    }
}
