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
        packages("com.me.resource","com.me.dto", "com.fasterxml.jackson.jaxrs.base")
        register(RequestContextFilter.class)
        //register(JacksonFeature.class)
    }
}
