package com.me.dto

import com.me.resource.AuthorResource
import com.sun.jersey.server.linking.Ref

/**
 * Created by chrislin on 5/6/2014.
 */
class Book {
    String id
    String title


    @Ref(resource=AuthorResource.class)
    URI b
}
