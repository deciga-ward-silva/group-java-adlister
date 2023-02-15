package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// This servlet is used to handle user logout.
@WebServlet(name = "controllers.LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    // This method is called when a GET request is made to the "/logout" URL.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Remove the "user" attribute from the session and invalidate the session.
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();

        // Redirect to the login page.
        response.sendRedirect("/login");
    }
}
