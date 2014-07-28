/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.jsf;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Francesco
 */
@Named(value = "validationBean")
@RequestScoped
public class ValidationBean {

    @Size(min = 3, message = "at least 3 characters")
    private String name;
    
    @Min(18)
    @Max(25)
    private int age;
    
    @Pattern(regexp = "[0-9]{5}",message = "a zip code must have 5 numbers")
    private String zip;

    /**
     * Creates a new instance of ValidationBean
     */
    public ValidationBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}
