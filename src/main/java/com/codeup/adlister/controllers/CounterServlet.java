package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// This line maps the CounterServlet class to the "/count" URL.
@WebServlet(name = "controllers.CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int counter = 0;

    // This method is called when a GET request is made to the "/count" URL.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Increment the counter.
        counter += 1;

        // Write a response to the client with the updated counter value.
        response.getWriter().println("<h1>The count is " + counter + ".</h1>");
    }
}
