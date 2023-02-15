package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// This line maps the DeleteAdServlet class to the "/ads/delete" URL.
@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet {

    // This method is called when a GET request is made to the "/ads/delete" URL.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the ad ID from the request parameter.
        Long adId = Long.valueOf(request.getParameter("id"));

        // Delete the ad from the database.
        Ads adsDao = DaoFactory.getAdsDao();
        adsDao.delete(adId);

        // Redirect to the profile page.
        response.sendRedirect("/profile");
    }

<<<<<<< HEAD
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long adId = Long.valueOf(request.getParameter("id"));
=======
    // This method is called when a POST request is made to the "/ads/delete" URL.
    protected void doPost(HttpServlet request, HttpServletResponse response) throws ServletException, IOException {
        // Get the ad ID from the init parameter (note: this method has a typo).
        Long adId = Long.valueOf(request.getInitParameter("id"));

        // Delete the ad from the database.
>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
        Ads adsDao = DaoFactory.getAdsDao();
        adsDao.delete(adId);

        // Redirect to the profile page.
        response.sendRedirect("/profile");
    }
<<<<<<< HEAD
=======

    // This method is not used.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
>>>>>>> b446132f5392a265bf79f78d0744ca0799297fbf
}
