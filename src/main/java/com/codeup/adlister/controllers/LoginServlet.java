package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// This servlet is used to handle user login.
@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    // This method is called when a GET request is made to the "/login" URL.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // If the user is already logged in, redirect to the profile page.
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }

        // Forward the request and response objects to the login.jsp page.
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    // This method is called when a POST request is made to the "/login" URL.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the username and password from the request parameters.
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Get the user from the database using the DaoFactory object.
        User user = DaoFactory.getUsersDao().findByUsername(username);

        // If the user doesn't exist, redirect to the login page.
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        // Check if the password is correct using the Password utility class.
        boolean validAttempt = Password.check(password, user.getPassword());

        // Get the last page visited by the user before being redirected to the login page.
        String lastPage = (String) request.getSession().getAttribute("last-page");

        // If the password is correct and a last page exists, redirect to the last page.
        if (validAttempt && lastPage != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect(lastPage);
        } else {
            // Otherwise, redirect to the profile page.
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        }
    }
}
