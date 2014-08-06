/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.resttest.websocket;

import java.io.IOException;
import javax.inject.Inject;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 * @author Francesco
 */
@ClientEndpoint
public class WebSocketClient {
    
    @Inject
    private MessageStack messageStack;
    
    @OnOpen
    public void onOpen(final Session session) throws IOException
    {
        session.getBasicRemote().sendText("Connection Opened");
    }
    
    @OnMessage
    public void receiveMessage(final String message, final Session session) throws IOException
    {
        messageStack.addMessage("Client received message: " + message);
    }
}
