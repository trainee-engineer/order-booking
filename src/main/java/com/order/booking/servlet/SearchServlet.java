package com.order.booking.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchText = request.getParameter("searchText");

        // You can perform your search logic here and get the search results

        // For demonstration purposes, let's assume you have a searchResults string
        String searchResults = "Search results for: " + searchText;

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(searchResults);
    }
}
