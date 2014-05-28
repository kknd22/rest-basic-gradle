package com.me.web

/**
 * Created by chrislin on 5/22/2014.
 */
import com.wordnik.swagger.jaxrs.config.WebXMLReader

import javax.servlet.ServletConfig;

public class SwaggerCustomConfigReader extends WebXMLReader {

    public SwaggerCustomConfigReader(ServletConfig sc) {
        super(sc)
    }

    @Override public String basePath() {
        return "";
        //return "http://localhost:8080/rest-basic/api";
    }

    @Override public String swaggerVersion() {
        return com.wordnik.swagger.core.SwaggerSpec.version();
    }

    @Override public String apiVersion() {
        return "2.3.4";
    }

    @Override public String modelPackages() {
        return "";
    }

    @Override public String apiFilterClassName() {
        return "";
    }

}