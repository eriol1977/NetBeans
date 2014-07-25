/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Francesco
 */
@Stateless
@Named
public class CustomerSessionBean {

    public List<Name> getCustomerNames()
    {
        List<Name> names = new ArrayList<>();
        
        names.add(new Name("Tony"));
        names.add(new Name("Rocky"));
        names.add(new Name("Horror"));
        
        return names;
    }
}
