/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.resttest;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Startup;
import javax.inject.Singleton;

/**
 *
 * @author Francesco
 */
@Singleton
@Startup
public class Library {

    private final List<Author> authors = new ArrayList<>();

    private final List<Book> books = new ArrayList<>();

    public Library() {
        authors.add(new Author(1,"Francesco", "Bertolino", 37));
        authors.add(new Author(2,"Stephen", "King", 55));
        authors.add(new Author(3,"George", "Martin", 63));

        books.add(new Book(1, "La Città degli Automi", authors.get(0), 355));
        books.add(new Book(2, "La Forgia del destino", authors.get(0), 400));
        books.add(new Book(3, "The Dome", authors.get(1), 890));
        books.add(new Book(4, "A Feast for Crows", authors.get(2), 1323));
    }

    public Book getBook(int id) {
        for (final Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public Author getAuthor(int id) {
        for (final Author a : authors) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
    
    public Author getAuthor(String nameStart) {
        for (final Author a : authors) {
            if(a.getName().startsWith(nameStart))
                return a;
        }
        return null;
    }
    
    public List<Author> getAuthors() {
        return authors;
    }

    public List<Book> getBooks() {
        return books;
    }
}
