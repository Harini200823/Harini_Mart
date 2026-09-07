package com.harini.harinimart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Using password to prevent the unused variable warning
        System.out.println("Login attempt for email: " + email + " with password length: " + password.length());

        boolean isValidUser = true; // Placeholder for actual validation

        if (isValidUser) {
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);
            response.sendRedirect("products");
        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}