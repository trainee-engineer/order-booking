package com.order.booking.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        String searchResults = generateSearchResults(query);

        response.setContentType("text/html");
        response.getWriter().write(searchResults);
    }

    private String generateSearchResults(String query) {
        // Simulated search results generation
        // In a real scenario, you'd query a database or an external API here
        StringBuilder resultsBuilder = new StringBuilder();
        resultsBuilder.append("<h2>Search results for: ").append(query).append("</h2>");
        resultsBuilder.append("<ul>");
        for (int i = 1; i <= 5; i++) {
            resultsBuilder.append("<li>Result ").append(i).append(" for '").append(query).append("'</li>");
        }
        resultsBuilder.append("</ul>");

        return resultsBuilder.toString();
    }
}