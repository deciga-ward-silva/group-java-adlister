package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// This servlet is used to redirect the user to a specified URL.
@WebServlet(name = "controllers.IntendedRedirectServlet", urlPatterns = "/redirect")
public class IntendedRedirectServlet extends HttpServlet {

    // This method is called when a GET request is made to the "/redirect" URL.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the redirect URL from the request parameter.
        String redirect = request.getParameter("redirect");

        // If the redirect URL is null or empty, set it to "/profile".
        if (redirect == null || redirect.isEmpty()) {
            redirect = "/profile";
        }

        // Redirect the user to the specified URL.
        response.sendRedirect(redirect);
    }
}
