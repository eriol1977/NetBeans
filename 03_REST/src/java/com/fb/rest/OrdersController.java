/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.rest;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author Francesco
 */
@Named(value = "ordersController")
@SessionScoped
public class OrdersController implements Serializable {
    
    private final Order order;

    /**
     * Creates a new instance of OrdersController
     */
    public OrdersController() {
        Client client = ClientBuilder.newClient();
        order = client
                .register(OrderReader.class)
                .target("http://localhost:8080/03_REST/services/orders")
                .path("{oid}")
                .resolveTemplate("oid", 1)
                .request()
                .get(Order.class);

    }

    public Order getOrder() {
        return order;
    }
    
}
