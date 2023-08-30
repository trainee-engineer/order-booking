package com.order.booking.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Shopping Cart", urlPatterns = "/cart")
public class ShoppingCartServlet extends HttpServlet {
    private List<Item> cartItems = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set cartItems attribute and forward to cart.jsp
        request.setAttribute("cartItems", cartItems);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    // Add, remove, or update cart items based on user actions
}

class Item {
    private String name;
    private double price;
    private int quantity;

    // Getters and setters
    public String setName() {
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }

    public double setPrice() {
        return price;
    }

    public void getPrice(double price) {
        this.price = price;
    }

    public int setQuantity() {
        return quantity;
    }

    public void getQuantity(int quantity) {
        this.quantity = quantity;
    }
}
