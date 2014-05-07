package com.me.dto

import com.me.resource.AuthorResource
import com.sun.jersey.server.linking.Ref

/**
 * Created by chrislin on 5/6/2014.
 */
public class Author {
    public String name
    public Integer id
    //List<Book> books

//    @Ref(resource=AuthorResource.class)
//    @Ref(value="authors/{id}")
//    public URI u
    public String getName() {
        return name
    }

    public Integer getId() {
        return id
    }
}
