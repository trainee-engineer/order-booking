package com.order.booking.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// todo in future need to convert into singleton class
public class DatabaseUtils1 {
    public DatabaseUtils1() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_booking?useSSL=false", "root", "root");
        return connection;
    }
}