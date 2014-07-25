/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.jsf;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Francesco
 */
@Named
@RequestScoped
public class Name {

    private String value = "Francesco";

    public Name() {
    }
    
    public Name(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
