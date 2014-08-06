/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.resttest.websocket;

import java.net.URI;
import javax.ejb.Startup;
import javax.inject.Singleton;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author Francesco
 */
@Singleton
@Startup
public class WebSocketConnector {

    boolean connected = false;
    
    public void connect() throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        container.connectToServer(WebSocketClient.class, URI.create("ws://localhost:8080/RestTest-1.0-SNAPSHOT/websocket"));
        connected = true;
    }

    public boolean isConnected() {
        return connected;
    }
}
