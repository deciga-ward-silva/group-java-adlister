package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.UserAds", urlPatterns = "/profile/userAds")
public class UserAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the user is logged in
        if (request.getSession().getAttribute("user") == null) {
            // If the user is not logged in, redirect to the login page
            response.sendRedirect("/login");
            return;
        }

        // Get all ads created by the user
        Ads adsDao = DaoFactory.getAdsDao();
        List<Ad> allAds = adsDao.all();

        // Set the user's ads as a request attribute
        request.setAttribute("allAds", allAds);

<<<<<<< HEAD
        // Send the request to profile.jsp //
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
=======
        // Send the request to all.jsp, which displays all of the user's ads
        request.getRequestDispatcher("/WEB-INF/ads/all.jsp").forward(request, response);
>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
    }
}
