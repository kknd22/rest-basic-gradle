package com.me.resttest

import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.server.spring.SpringLifecycleListener
import org.glassfish.jersey.server.spring.scope.RequestContextFilter
import org.glassfish.jersey.test.JerseyTest
import org.glassfish.jersey.test.TestProperties

import javax.ws.rs.core.Application

/**
 * Created by chrislin on 5/15/2014.
 */

abstract class AbstractBaseResourceTest extends JerseyTest {
    private final static String TEST_SUFFIX = 'Test'
    private final static String CTX_LOCATION_KEY = 'contextConfigLocation'
    private final static String XML_SUFFIX = '.XML'

    /**
     *
     * @return
     */
    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        def xml = this.getClass().simpleName - TEST_SUFFIX + XML_SUFFIX
        def rc = new ResourceConfig()
                .register(SpringLifecycleListener.class)
                .register(RequestContextFilter.class)
                .property(CTX_LOCATION_KEY, xml)
        //.property("spring.profiles.active", "development")

        configure(rc)
    }

    /**
     *
     * @param rc
     * @return
     */
    protected abstract Application configure(ResourceConfig rc)

}