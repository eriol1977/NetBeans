/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
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
@Path("orders")
public class OrderService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order((long) 1, "Book"));
        orders.add(new Order((long) 2, "Pen"));
        orders.add(new Order((long) 3, "Disk"));
        orders.add(new Order((long) 4, "Cup"));
        orders.add(new Order((long) 5, "Notebook"));
        return orders;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{oid}")
    public List<Order> getOrder(@PathParam("oid") int id) {
        List<Order> orders = new ArrayList<>(1);
        orders.add(new Order((long) id, "Laptop"));
        return orders;
    }
}
