package com.order.booking.servlet;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ForgotPasswordServlet",urlPatterns = "/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String email = request.getParameter("email");

        // Generate a random password reset token (you can use any method you prefer)
        String resetToken = UUID.randomUUID().toString();

        // Show a message to the user that the reset link has been sent
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Password Reset Link Sent</h1>");
        out.println("<p>A password reset link has been sent to your email address. Please check your inbox.</p>");
        out.println("</body></html>");
    }

}


