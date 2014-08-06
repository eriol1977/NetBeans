package com.fb.resttest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Francesco
 */
public class TestRequest {

    public TestRequest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetRequest() {
        Client client = ClientBuilder.newClient();
        client.register(AuthorReader.class).register(AuthorListReader.class).register(BookReader.class).register(BookListReader.class);
        WebTarget target = client.target("http://localhost:8080/RestTest-1.0-SNAPSHOT/rest/library");

        Author author = target.path("author/{id}").resolveTemplate("id", 1).request().get(Author.class);
        Assert.assertNotNull(author);
        Assert.assertEquals("Francesco", author.getName());
        Assert.assertEquals("Bertolino", author.getSurname());
        Assert.assertEquals(37, author.getAge());

        final List<Author> authors = target.path("authors").request().get(new GenericType<List<Author>>() {
        });
        Assert.assertEquals(3, authors.size());

        Book book = target.path("book/{id}").resolveTemplate("id", 1).request().get(Book.class);
        Assert.assertNotNull(book);
        Assert.assertEquals("La Fiamma Eterna", book.getTitle());
        Assert.assertEquals(355, book.getPages());
        Assert.assertEquals("Francesco", book.getAuthor().getName());

        List<Book> books = target.path("books").request().get(new GenericType<List<Book>>() {
        });
        Assert.assertEquals(4, books.size());
    }

//    @Test
//    public void testDeleteRequest() {
//        Client client = ClientBuilder.newClient();
//        client.register(AuthorReader.class);
//        
//        Author deleted = client.target("http://localhost:8080/RestTest-1.0-SNAPSHOT/rest/library/deleteAuthor").path("{id}").resolveTemplate("id", 3).request().delete(Author.class);
//        Assert.assertEquals("George", deleted.getName());
//        Assert.assertEquals("Martin", deleted.getSurname());
//    }
}
