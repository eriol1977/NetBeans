/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.resttest.websocket;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Francesco
 */
@Named(value = "webSocketController")
@RequestScoped
public class WebSocketController {

    private String message;

    private final WebSocketConnector connector = new WebSocketConnector();

    @Inject
    private MessageStack messageStack;

    /**
     * Creates a new instance of WebSocketController
     */
    public WebSocketController() {
    }

    public List<String> getMessages() {
        return messageStack.getMessages();
    }

    public String openConnection() throws Exception {
        connector.connect();
        return "websocketPage";
    }

    public String refresh()
    {
        return "websocketPage";
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
