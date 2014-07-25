/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author Francesco
 */
@WebFilter("/account")
public class LoggingFilter implements Filter {

    private ServletContext context;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
        context.log("Logging filter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        this.context.log("Servlet called with parameter: " + request.getParameter("text"));
        
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        context.log("Logging filter destroyed");
    }
    
}
