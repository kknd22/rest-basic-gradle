package com.me.web

import com.me.config.rest.RestSpringConfig
import com.me.config.shared.SpringConfig
import org.glassfish.jersey.server.ResourceConfig
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
class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        //XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
        //rootContext.setConfigLocations(new String[] { "classpath*:applicationContext.xml" });
        //container.addListener(new ContextLoaderListener(rootContext));

        // Create the 'root' Spring application context
        println("############################################################")
        println("############################################################")

        def rootContext = new AnnotationConfigWebApplicationContext()
        rootContext.register(RestSpringConfig.class)

        // Manage the lifecycle of the root application context
        sc.addListener(new ContextLoaderListener(rootContext))

        // -- see readme in one-erar-multiple-war project how to add ref to the spring config in ear-jars
        sc.setInitParameter('contextConfigLocation', "com.me.config.shared.SpringConfig");
        sc.addListener("org.springframework.web.context.request.RequestContextListener");
        def r = new ResourceConfig()
                .packages("com.me.resource")

        // Register and map the dispatcher servlet
        def dispatcher = sc.addServlet('jersey-dispatcher', new ServletContainer(r))
        dispatcher.setLoadOnStartup(1)
        dispatcher.addMapping("/api/*")

        FilterRegistration charEncodingfilterReg = sc.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class)
        charEncodingfilterReg.setInitParameter("encoding", "UTF-8")
        charEncodingfilterReg.setInitParameter("forceEncoding", "true")
        charEncodingfilterReg.addMappingForUrlPatterns(null, false, "/api/*")
    }
}