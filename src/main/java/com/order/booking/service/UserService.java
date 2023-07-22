package com.order.booking.service;

import com.order.booking.dao.UserDao;
import com.order.booking.entity.User;

import java.sql.SQLException;

public class UserService
{
    private UserDao userDao;
    public UserService()
    {
        userDao = new UserDao();
    }
    public User login(String username, String password) throws SQLException
    {
        return userDao.login(username,password);
    }

    public String save(User user) throws SQLException {
        return userDao.save(user);
    }
}