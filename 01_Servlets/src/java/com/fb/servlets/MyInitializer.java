/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.servlets;

import java.util.Set;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * The addServlet method returns ServletRegistration.Dynamic, which can then be
 * used to create URL mappings, set security roles, set initialization
 * parameters, and manage other configuration items
 *
 * OBS!!! The ServletContainerInitializer implementation is intented to be
 * bundled in a JAR file which is in turn been dropped in /WEB-INF/lib of the
 * webapp. The JAR file itself should have a
 * /META-INF/services/javax.servlet.ServletContainerInitializer file containing
 * the FQN of the ServletContainerInitializer implementation in the JAR. Please
 * note that this file should thus not be placed in the webapp itself!
 *
 * @author Francesco
 */
public class MyInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        ServletRegistration.Dynamic reg = ctx.addServlet("MyServlet", "org.example.MyServlet");
        reg.addMapping("/myServlet");

        FilterRegistration.Dynamic filterReg = ctx.addFilter("LoggingFilter", "org.example.LoggingFilter");
        filterReg.addMappingForUrlPatterns(null, false, "/");
        
        ctx.addListener("org.example.MyContextListener");
    }

}
