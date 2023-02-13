package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long adId = Long.valueOf(request.getParameter("id"));
        Ads adsDao = DaoFactory.getAdsDao();
        adsDao.delete(adId);
        response.sendRedirect("/profile");
    }

    protected void doPost(HttpServlet request, HttpServletResponse response) throws ServletException, IOException {
        Long adId = Long.valueOf(request.getInitParameter("id"));
        Ads adsDao = DaoFactory.getAdsDao();
        adsDao.delete(adId);
        response.sendRedirect("/profile");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 7218a12e0060644bcd8d4ae22259c7c0e7dff609
