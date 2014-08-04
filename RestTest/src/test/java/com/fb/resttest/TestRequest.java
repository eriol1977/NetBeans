package com.fb.resttest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
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
        client.register(AuthorReader.class);
        
        Author original = client.target("http://localhost:8080/RestTest-1.0-SNAPSHOT/rest/library/author/1").request().get(Author.class);
        Assert.assertEquals("Francesco", original.getName());
        Assert.assertEquals("Bertolino", original.getSurname());
        Assert.assertEquals(37, original.getAge());
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
