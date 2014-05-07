package com.me.dto;

import com.me.resource.HalDummyResource;
import com.sun.jersey.server.linking.Ref;

import java.net.URI;

/**
 * Created by chrislin on 5/7/2014.
 */
public class HalDummy {
    private String dummyString;
    private Integer id;

    @Ref(resource=HalDummyResource.class)
    public URI dummy_self;

    public HalDummy(Integer id) {
        this.id = id;
    }

    public HalDummy(Integer id, String dummyString) {
        this.dummyString = dummyString;
        this.id = id;
    }

    public String getDummyString() {
        return dummyString;
    }

    public void setDummyString(String dummyString) {
        this.dummyString = dummyString;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
