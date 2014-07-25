/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Francesco
 */
@WebServlet(urlPatterns = {"/account", "/accountServlet"}, initParams = {
    @WebInitParam(name = "type", value = "checking")})
public class AccountServlet extends HttpServlet {

    String type;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        type = config.getInitParameter("type");
    }

    @Override
    public void destroy() {
        type = null;
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // The ServletContext provides detail about the execution environment of 
        // the servlets and is used to communicate with the container
        ServletContext servletContext = req.getServletContext();
        SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
        
        // bind objects to the session
        HttpSession session = req.getSession();
        session.setAttribute("user", "gigio");
        Object attribute = session.getAttribute("outro");
        
        // A servlet may forward a request to another servlet if further processing is required
        // req.getRequestDispatcher("bank").forward(req, resp);
        
        //in this case, the original request object is not available to the redirected URL
        //resp.sendRedirect("http://example.com/SomeOtherServlet");
        
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><head>");
            out.println("<title>MyServlet</title>");
            out.println("</head><body>");
            out.println("<h1>My First Servlet</h1>");
            out.println("<h2>" + req.getParameter("text") + "</h2>");
            out.println("<h3>" + type + "</h3>");
            out.println("</body></html>");
        } finally {

        }
    }

}
