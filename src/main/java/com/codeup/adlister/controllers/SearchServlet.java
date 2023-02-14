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

@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchTerm = request.getParameter("searchTerm");
        List<Ad> ads = DaoFactory.getAdsDao().searchAds(searchTerm);
        if (ads.isEmpty()) {
            String errorMessage = "Search result not found. Please try again.";
            request.setAttribute("errorMessage", errorMessage);
        } else {
            Ad ad = ads.get(0);
            request.setAttribute("ad", ad);
        }
        request.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(request, response);




    }
}
