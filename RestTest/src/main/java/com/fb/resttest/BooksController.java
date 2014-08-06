/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.resttest;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Francesco
 */
@Named(value = "booksController")
@RequestScoped
public class BooksController {

    /**
     * Creates a new instance of BooksController
     */
    public BooksController() {
    }

    public String getTitle() {
        return "Book List";
    }

    public List<Book> getBooks() {
        Client client = ClientBuilder.newClient();
        client.register(BookListReader.class);
        final List<Book> books = client.target("http://localhost:8080/RestTest-1.0-SNAPSHOT/rest/library").path("books").request().get(new GenericType<List<Book>>() {
        });
        return books;
    }
}
