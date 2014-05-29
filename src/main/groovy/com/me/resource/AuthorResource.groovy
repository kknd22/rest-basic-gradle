package com.me.resource

import com.fasterxml.jackson.databind.ObjectMapper
import com.me.dto.Author
import com.me.dto.Book
import com.me.exception.MeRumtineException
import com.me.exceptionmapper.MeExceptionMapper
import com.me.service.AuthorService
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import com.wordnik.swagger.annotations.ApiResponse
import com.wordnik.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType

//import javax.ws.rs.core.Context
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

//import javax.ws.rs.core.SecurityContext

//@Path("/api/authors") (for servlet 2.5)
@Path("/authors")
//@Component  no need otherwise will reg twice

@Produces([MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN])
@Consumes([MediaType.APPLICATION_JSON])
@Api(value = "/authors", description = "Authors resources' API")
class AuthorResource {
    @Context
    UriInfo uriInfo;

    @Autowired
    AuthorService authorService;

    /**
     *
     * @param names
     * @param pageSize
     * @return
     */
    //@Path("")
    @GET
    @ApiOperation(value = "List all authors", notes = "List all authors using paging", response = Author.class, responseContainer = "List")
    @ApiResponses(value = [
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Out of luck - something wrong in Server")])
    Response listAuthors(@QueryParam("names") String names, @QueryParam("pageSize") Integer pageSize) {
        println ("name is: $names, pageSize is: $pageSize")
        def ass = []
        ass << authorSimple(1) << authorFull(2)
        Response.ok().entity(ass).build()
    }

    /**
     *
     * @param id
     * @return
     */
    @Path("/{id}")
    @GET
    @ApiOperation(value = "Retrieve author using id", notes = "use 111 test for success, 222 for 500 response and others for 404 response", response = Author.class)
    @ApiResponses(value = [
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404 , message = "Not Found"),
            @ApiResponse(code = 500, message = "Out of luck - something wrong in Server")])
    Response getAuthor(@PathParam("id") Integer id) {
        println ("id is: $id")

        if (id != 111 && id != 222)
            throw new MeRumtineException("MeRuntimeException Throwed message#################")
        if (id == 222)
            Response.status(Response.Status.NOT_FOUND).build()

        UriBuilder ub = uriInfo.getAbsolutePathBuilder()
        def u = ub.build()
        def a = authorSimple(id)
        a.name=authorService.myBean.value1

        Response.ok(a).link(u, "self").build()
    }

    @POST
    @ApiOperation(value = "Create new author", notes = "Create new author")
    @ApiResponses([
        @ApiResponse(code = 201, message = "Author created successfully"),
        @ApiResponse(code = 409, message = "Author with such name already exists")])
    Response createAuthor(Author a) {
        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        def u = ub.segment("999").build()
        println(a.dump())
        Response.created().link(u, "self").build();
    }

    @Path("/{id}")
    @PUT
    @ApiOperation(value = "Update author partially", notes = "update author partially - treat json as string, using post request json schema" )
    @ApiResponses([
            @ApiResponse(code = 204, message = "Author updated successfully" ),
            @ApiResponse(code = 409, message = "Author with such name already exists")])
    Response updateAuthor(String aString) {
        println("aString: $aString")

        def mp = new ObjectMapper()
        def o1 = authorFull(3434)
        println("o1: ${mp.writeValueAsString(o1)}")

        def o2 = mp.readerForUpdating(o1).readValue(aString)
        println("o2: ${mp.writeValueAsString(o2)}")
        Response.noContent().build();
    }

    @Path("/{id}")
    @DELETE
    @ApiOperation(value = "Delete author", notes = "delete author use 111 for 204 response, others for 404 not found response")
    @ApiResponses([
            @ApiResponse(code = 204, message = "Author updated successfully"),
            @ApiResponse(code = 404 , message = "Not Found"),
            @ApiResponse(code = 500, message = "Out of luck - something wrong in Server")])
    Response deleteAuthor(@PathParam("id") Integer id) {
        println("id to be deleted: $id")

        if (id == 111)
            Response.noContent().build()
        else
            Response.status(Response.Status.NOT_FOUND).build();
    }

    /**
     *
     * @param authorId
     * @param id
     * @return
     */
    @Path("/{authorId}/books/{id}")
    @GET
    @ApiOperation(value = "Retrieve a book from an author", notes = "retrieve book", response = Book.class)
    @ApiResponses([
            @ApiResponse(code = 200, message = "Book retrieved successfully"),
            @ApiResponse(code = 500, message = "Out of luck - something wrong in Server")])
    Response getAuthorBook(@PathParam("authorId") Integer authorId, @PathParam("id") String id) {
        println ("authorId is: $authorId, id is: $id")
        def b = authorBook(authorId, id)
        Response.ok().entity(b).build();
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
