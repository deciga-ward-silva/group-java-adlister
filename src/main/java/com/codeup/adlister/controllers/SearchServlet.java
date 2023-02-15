package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// This servlet is used to search for ads.
@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    // This method is called when a GET request is made to the "/search" URL.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the search term from the request.
        String searchTerm = request.getParameter("searchTerm");

        // Search for ads that match the search term.
        List<Ad> ads = DaoFactory.getAdsDao().searchAds(searchTerm);

        // If no matching ads are found, set an error message. Otherwise, set the first ad in the list as a request attribute.
        if (ads.isEmpty()) {
            String errorMessage = "Search result not found. Please try again.";
            request.setAttribute("errorMessage", errorMessage);
        } else {
            Ad ad = ads.get(0);
            request.setAttribute("ad", ad);
        }

        // Forward the request and response objects to the search JSP page.
        request.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(request, response);
    }
}
