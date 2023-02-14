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

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // get the ad details from the form
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        // validate the ad details
        List<String> errors = new ArrayList<>();
        if (title == null || title.trim().isEmpty()) {
            errors.add("Title is required.");
        }
        if (description == null || description.trim().isEmpty()) {
            errors.add("Description is required.");
        }

        if (errors.isEmpty()) {
            // create the ad in the database
            User user = (User) request.getSession().getAttribute("user");
            Ad ad = new Ad(user.getId(), title, description);
            long adId = DaoFactory.getAdsDao().insert(ad);
            Ad insertedAd = DaoFactory.getAdsDao().findOne(adId);

            // redirect to the profile page
            response.sendRedirect(request.getContextPath() + "/profile");
        } else {
            // handle errors
            request.getSession().setAttribute("errors", errors);
            response.sendRedirect(request.getContextPath() + "/ads/create");
        }
    }

}
