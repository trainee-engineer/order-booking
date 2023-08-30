package com.order.booking.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//todo in future need to convert into singleton class
public final class DatabaseUtils{
//    private final static DatabaseUtils DATABASE_UTILS = new DatabaseUtils();//eager loading
private  static DatabaseUtils DATABASE_UTILS;
private final static Object lock = new Object();
    private DatabaseUtils()
    {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }

    }
   //Normal case mean without multithreading
    // 10 no of request
    //1 -> obj = null then check it and create new instance then return
    // 2-> obj is not null then return



    // 10 no of request
    //10:30:02:100:1001->(1 & 2) -> obj = null then check it and create new instance then return
    // 2-> obj is not null then return
    public static DatabaseUtils getInstance(){
        if(DATABASE_UTILS == null){
            synchronized (lock){
               if(DATABASE_UTILS == null){
                   DATABASE_UTILS = new DatabaseUtils();
               }
            }
        }

        return DATABASE_UTILS;
    }


    public Connection getConnection() throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_booking?useSSL=false", "root", "root");
        return connection;
    }
}
