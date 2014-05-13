package com.me.resource

import com.me.dto.Author
import com.me.dto.Book
import com.me.dto.HalDummy
import com.me.service.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Context
import javax.ws.rs.core.Link

//import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

//import javax.ws.rs.core.SecurityContext

//@Path("/api/authors") (for servlet 2.5)
@Path("/authors")
@Component
@Produces([MediaType.APPLICATION_JSON])
@Consumes([MediaType.APPLICATION_JSON])
class AuthorResource {
    @Context
    UriInfo uriInfo;

    @Autowired
    AuthorService authorService;

    /**
     *
     * @param id
     * @return
     */
    @Path("{id}")
    @GET
    Response getAuthor(@PathParam("id") Integer id) {
        println ("id is: $id")
        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        def u = ub.build()
        def a = authorSimple(id)
        a.name=authorService.myBean.value1

/*
        Response.ok().
                link("http://oracle.com", "parent").
                link(new URI("http://jersey.java.net"), "framework").
                build();
*/
        Response.ok(a).link(u, "self").build();
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
    //@Path("")
    @GET
    Response listAuthors(@QueryParam("names") String names, @QueryParam("pageSize") Integer pageSize) {
        println ("name is: $names, pageSize is: $pageSize")
        def ass = []
        ass << authorSimple(1) << authorFull(2)
        Response.ok().entity(ass).build();
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
     * @param id
     * @return
     */
    private Author authorFull(Integer id) {
        new Author(id: id, name: "author-name-22",
                books: [] << new Book(id: 'book-id-21', title: "title-21") << new Book(id: 'book-id-22', title: "title-22"))
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
