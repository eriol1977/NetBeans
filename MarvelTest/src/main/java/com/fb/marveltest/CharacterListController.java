/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.marveltest;

import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Francesco
 */
@ManagedBean(name = "characterListController")
@ViewScoped
public class CharacterListController {

    private List<String> names;
    
    private String selectedName;
    
    /**
     * Creates a new instance of CharacterListController
     */
    public CharacterListController() {
        names = Arrays.asList("Thor","Iron Man", "Captain America");
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String getSelectedName() {
        return selectedName;
    }

    public void setSelectedName(String selectedName) {
        this.selectedName = selectedName;
    }
}
