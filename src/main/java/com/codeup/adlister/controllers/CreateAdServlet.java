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
import java.util.ArrayList;
import java.util.List;

// This line maps the CreateAdServlet class to the "/ads/create" URL.
@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {

    // This method is called when a GET request is made to the "/ads/create" URL.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // If the user is not logged in, redirect to the login page.
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        // Otherwise, forward the request and response objects to the create.jsp page.
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
    }

    // This method is called when a POST request is made to the "/ads/create" URL.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get the ad details from the form.
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        // Validate the ad details and add any errors to a list.
        List<String> errors = new ArrayList<>();
        if (title == null || title.trim().isEmpty()) {
            errors.add("Title is required.");
        }
        if (description == null || description.trim().isEmpty()) {
            errors.add("Description is required.");
        }

        if (errors.isEmpty()) {
            // Create the ad in the database.
            User user = (User) request.getSession().getAttribute("user");
            Ad ad = new Ad(user.getId(), title, description);
            long adId = DaoFactory.getAdsDao().insert(ad);
            Ad insertedAd = DaoFactory.getAdsDao().findOne(adId);

            // Redirect to the profile page. //
            response.sendRedirect(request.getContextPath() + "/profile");
        } else {
            // Handle errors.
            request.getSession().setAttribute("errors", errors);
            response.sendRedirect(request.getContextPath() + "/ads/create");
        }
    }
}