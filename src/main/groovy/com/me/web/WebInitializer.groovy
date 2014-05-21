package com.me.web

import com.me.config.rest.RestSpringConfig
import com.me.config.shared.SpringConfig
import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.server.spring.scope.RequestContextFilter
import org.glassfish.jersey.servlet.ServletContainer
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.filter.CharacterEncodingFilter

import javax.servlet.FilterRegistration
import javax.servlet.ServletContext
import javax.servlet.ServletException

/**
 * Created by chrislin on 5/13/2014.
 */
class WebInitializer {
/*
    implements
} WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        //XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
        //rootContext.setConfigLocations(new String[] { "classpath*:applicationContext.xml" });
        //container.addListener(new ContextLoaderListener(rootContext));

        // Create the 'root' Spring application context
        println("############################################################")
        println("############################################################")

        // -- see readme in one-ear-multiple-war project how to add ref to the spring config in ear-jars
        sc.setInitParameter('contextConfigLocation', "com.me.config.shared.RestSpringConfig");
        //sc.addListener("org.springframework.web.context.request.RequestContextListener");

        def rootContext = new AnnotationConfigWebApplicationContext()
        rootContext.register(SpringConfig.class)

        // Manage the lifecycle of the root application context
        sc.addListener(new ContextLoaderListener(rootContext))

        def r = new ResourceConfig()
                .packages("com.me.resource")
                .packages("com.me.exceptionmapper")
                .register(RequestContextFilter.class)

        // Register and map the dispatcher servlet
        def dispatcher = sc.addServlet('jersey-dispatcher', new ServletContainer(r))
        dispatcher.setLoadOnStartup(1)
        dispatcher.addMapping("/api*/
/*")
*/

/*
        supress jboss build-in easyrest
        if not you will see this: JBWEB000287: Exception sending context initialized event to
        listener instance of class org.springframework.web.context.ContextLoaderListener:
        java.lang.IllegalStateException: Cannot initialize context because
        there is already a root application context present
        - check whether you have multiple ContextLoader* definitions in your web.xml!
*/
/*
        dispatcher.setInitParameter('resteasy.scan', 'false');
        dispatcher.setInitParameter('resteasy.scan.providers', 'false');
        dispatcher.setInitParameter('resteasy.scan.resources', 'false');

        FilterRegistration charEncodingfilterReg = sc.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class)
        charEncodingfilterReg.setInitParameter("encoding", "UTF-8")
        charEncodingfilterReg.setInitParameter("forceEncoding", "true")
        charEncodingfilterReg.addMappingForUrlPatterns(null, false, "/api*/
/*")
    }
*/
}