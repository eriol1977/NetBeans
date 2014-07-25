/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/**
 * Event listeners provide life-cycle callback events for ServletContext, HttpSession, and
 * ServletRequest objects.
 * A typical example of these listeners is where an additional
 * servlet is registered programmatically without an explicit need for the programmer to
 * do so, or a database connection is initialized and restored back at the application level.
 */
@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        ServletRegistration.Dynamic reg = context.addServlet("AnotherServlet", "com.fb.servlets.AnotherServlet");
        reg.addMapping("/anotherServlet");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
}
