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

// This servlet allows users to edit an existing ad.
@WebServlet(name = "controllers.Edit", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet {

    // This method is called when a GET request is made to the "/ads/edit" URL.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the user is logged in before allowing access to edit ads.
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        // Get the ad ID from the request parameter.
        Long adId = Long.valueOf(request.getParameter("id"));

        // Get the ad from the database.
        Ads adsDao = DaoFactory.getAdsDao();
        Ad ad = adsDao.findOne(adId);

        // Set the ad as a request attribute.
        request.setAttribute("ad", ad);

        // Forward the request and response objects to the edit.jsp page.
        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
    }

    // This method is called when a POST request is made to the "/ads/edit" URL.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the user is logged in.
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        // Get the ad ID from the request parameter.
        Long adId = Long.valueOf(request.getParameter("id"));

        // Get the updated ad information from the request.
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        // Update the ad in the database.
        Ads adsDao = DaoFactory.getAdsDao();
        Ad ad = adsDao.findOne(adId);
        ad.setTitle(title);
        ad.setDescription(description);
        adsDao.update(ad);

        // Redirect the user to the ad detail page.
        response.sendRedirect("/ads?id=" + adId);
    }
}
