package com.me.resource

import com.me.dto.Author
import com.me.dto.Book
import org.springframework.stereotype.Component

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam

//import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
//import javax.ws.rs.core.SecurityContext

@Path("/authors")
@Component
@Produces([MediaType.APPLICATION_JSON])
@Consumes([MediaType.APPLICATION_JSON])
class AuthorResource {

    /**
     *
     * @param id
     * @return
     */
    @Path("{id}")
    @GET
    Response getAuthor(@PathParam("id") Integer id) {
        println ("id is: $id")
        def a = authorSimple(id)
        Response.ok().entity(a).build();
    }

    /**
     *
     * @param authorId
     * @param id
     * @return
     */
    @Path("{authorId}/books/{id}")
    @GET
    Response getAuthorBook(@PathParam("authorId") Integer authorId, @PathParam("id") String id) {
        println ("authorId is: $authorId, id is: $id")
        def b = authorBook(authorId, id)
        Response.ok().entity(b).build();
    }

    /**
     *
     * @param names
     * @param pageSize
     * @return
     */
    @GET
    Response listAuthors(@QueryParam("names") String names, @QueryParam("pageSize") Integer pageSize) {
        println ("name is: $names, pageSize is: $pageSize")
        def a = authorSimple(123)
        Response.ok().entity(a).build();
    }

    /**
     *
     * @param id
     * @return
     */
    private Author authorSimple(Integer id) {
        new Author(id: id, name: "author-name-1")
    }

    /**
     *
     * @param authorId
     * @param id
     * @return
     */
    private Book authorBook(Integer authorId, String id) {
        new Book(id: id, title: "book-title-$id-with-author-id-$authorId")
    }
}
