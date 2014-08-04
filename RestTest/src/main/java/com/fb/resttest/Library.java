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

    private int authorIdCounter = 1;
    
    private int bookIdCounter = 1;
    
    private final List<Author> authors = new ArrayList<>();

    private final List<Book> books = new ArrayList<>();

    public Library() {
        authors.add(new Author(getAuthorId(),"Francesco", "Bertolino", 37));
        authors.add(new Author(getAuthorId(),"Stephen", "King", 55));
        authors.add(new Author(getAuthorId(),"George", "Martin", 63));

        books.add(new Book(getBookId(), "La Fiamma Eterna", authors.get(0), 355));
        books.add(new Book(getBookId(), "La Forgia del destino", authors.get(0), 400));
        books.add(new Book(getBookId(), "The Dome", authors.get(1), 890));
        books.add(new Book(getBookId(), "A Feast for Crows", authors.get(2), 1323));
    }

    private int getBookId()
    {
        return bookIdCounter++;
    }
    
    private int getAuthorId()
    {
        return authorIdCounter++;
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
    
    public Author addAuthor(final String name, final String surname, final int age)
    {
        final Author author = new Author(getAuthorId(), name, surname, age);
        this.authors.add(author);
        return author;
    }
}
