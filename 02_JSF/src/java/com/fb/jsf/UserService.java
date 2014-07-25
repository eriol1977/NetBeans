/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.jsf;

import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Francesco
 */
@Named
@SessionScoped
public class UserService {

    private User user = new User();
    
    private String loginMessage;
    
    /**
     * Creates a new instance of User
     */
    public UserService() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
    
    public void register(ActionEvent event)
    {
        setLoginMessage("User logged in: " + user.getName());
    }
}
