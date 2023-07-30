package com.order.booking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resetPassword")
public class ResetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        // Here, you would implement the logic to send a password reset email to the provided username or email address.
        // For this example, we will just print a message indicating a password reset request.
        System.out.println("Password reset requested for: " + username);

        // You could redirect the user to a "Password Reset Confirmation" page.
        // For this example, we will just redirect back to the forget_password.html page.
        response.sendRedirect("/src/main/webapp/forget_password.html");
    }
}
