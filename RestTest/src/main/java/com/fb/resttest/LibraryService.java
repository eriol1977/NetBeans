/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.resttest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Francesco
 */
@Path("library")
public class LibraryService {

    @Inject
    private Library library;

    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return library.getBooks();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/book/{id}")
    public Book getBook(@PathParam("id") int id) {
        return library.getBook(id);
    }

    @GET
    @Path("/authors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthors() {
        return library.getAuthors();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/author/{id}")
    public Author getAuthor(@PathParam("id") int id) {
        return library.getAuthor(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/authorByName")
    public Author getAuthor(@QueryParam("name") String name) {
        return library.getAuthor(name);
    }

    @POST
    @Path("addAuthor")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Author addAuthor(@FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("age") int age) {
        return library.addAuthor(name, surname, age);
    }
}
