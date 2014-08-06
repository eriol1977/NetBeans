/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.resttest.websocket;

import java.io.IOException;
import javax.inject.Inject;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Francesco
 */
@ServerEndpoint("/websocket")
public class WebSocketServer {
    
    @Inject
    private MessageStack messageStack;
    
    @OnMessage
    public void receiveMessage(final String message, final Session session) throws IOException
    {
        messageStack.addMessage("Server received message: " + message);
        session.getBasicRemote().sendText("Hello Client!");
    }
}
