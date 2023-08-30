package com.order.booking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenFashionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Create a simple HTML page for the Men's Fashion section
        String htmlResponse = "<!DOCTYPE html>"
                + "<html><head><title>Men's Fashion</title></head><body>"
                + "<h1>Men's Fashion Section</h1>"
                + "<p>Discover the latest trends and timeless classics in men's fashion.</p>"
                + "<a href=\"index.html\">Back to Home</a>"
                + "</body></html>";

        response.getWriter().write(htmlResponse);
    }
}
