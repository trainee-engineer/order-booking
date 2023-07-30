package com.order.booking.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addToCart")
public class CartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("product_name");
        double price = Double.parseDouble(request.getParameter("price"));

        // Here, you can implement the logic to add the item to the cart (e.g., save to a session variable or database).

        // For demonstration purposes, let's just redirect the user back to the "Add to Cart" page after adding the item.
        response.sendRedirect("index.html");
    }
}

