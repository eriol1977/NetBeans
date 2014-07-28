/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.jsf;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlInputSecret;
import javax.inject.Named;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Francesco
 */
@Named(value = "user")
@SessionScoped
public class User implements Serializable {

    private String name;

    private String password;

    private String status;

    /**
     * Creates a new instance of User
     */
    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void checkPassword(AjaxBehaviorEvent evt) {
        HtmlInputSecret source = (HtmlInputSecret) evt.getSource();
        String pwd = (String) source.getValue();
        /// bla bla bla
    }

    public void login(ActionEvent evt) {
        if (name.equals(password)) {
            status = "Login successful";
        } else {
            status = "Login failed";
        }
    }
}
