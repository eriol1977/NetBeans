/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.resttest.websocket;

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
public class MessageStack {
    
    private final List<String> messages = new ArrayList<>();

    public List<String> getMessages() {
        return messages;
    }
       
    public int size()
    {
        return this.messages.size();
    }
    
    public String getLastMessage()
    {
        return this.messages.get(size()-1);
    }
    
    public void addMessage(final String message)
    {
        this.messages.add(message);
    }
    
}
