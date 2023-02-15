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

// This servlet is used to handle user registration.
@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    // This method is called when a GET request is made to the "/register" URL.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request and response objects to the register JSP page.
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    // This method is called when a POST request is made to the "/register" URL.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the username, email, password, and password confirmation from the request.
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // Hash the password and check if it matches the hashed password.
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        boolean passwordsMatch = BCrypt.checkpw(password, hash);

        // Check if the input is valid.
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (! password.equals(passwordConfirmation));

        // If there are input errors, redirect to the registration page and return.
        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        // Create a new User object and save it to the database.
        password = Password.hash(password);
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);

        // Redirect to the login page.
        response.sendRedirect("/login");
    }
}
