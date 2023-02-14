package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controller.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the currently logged-in user
        User user = (User) request.getSession().getAttribute("user");

        // Retrieve the ads for the current user
        List<Ad> ads = DaoFactory.getAdsDao().findByUserId(user.getId());

        // Add the ads as an attribute to the request object
        request.setAttribute("ads", ads);

        // Forward the request to the profile.jsp file
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

}