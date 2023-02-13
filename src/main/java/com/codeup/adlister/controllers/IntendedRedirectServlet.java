package com.codeup.adlister.controllers;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.IntendedRedirectServlet", urlPatterns = "/redirect")
public class IntendedRedirectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = request.getParameter("redirect");
        if(redirect == null || redirect.isEmpty()) {
            redirect = "/profile";

        }
        response.sendRedirect(redirect);
    }
}
