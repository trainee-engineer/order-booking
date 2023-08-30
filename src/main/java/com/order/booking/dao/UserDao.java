package com.order.booking.dao;

import com.order.booking.config.DatabaseUtils;
import com.order.booking.entity.User;
import javax.sql.rowset.spi.TransactionalWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDao
{
    private DatabaseUtils databaseUtils=DatabaseUtils.getInstance();
    public User login(String username, String password) throws SQLException
    {
        Connection conn = databaseUtils.getConnection();
        try
        {
            PreparedStatement statement = conn.prepareStatement("select * from user where username=? and password=?");
            statement.setString(1, username);
            statement.setString(2, password);


            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setUsername(rs.getString(4));
                user.setPassword(rs.getString(5));
                if (password.equals(user.getPassword())) {
                    return user;
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }
        finally
        {
            conn.close();
        }

    }
    public String save(User user) throws SQLException
    {
        Connection conn = databaseUtils.getConnection();
        try
        {
            conn.setAutoCommit(false);
            PreparedStatement stat = conn.prepareStatement("insert into user values(?,?,?,?,?)");
            stat.setInt(1, user.getId());
            stat.setString(2, user.getFirstName());
            stat.setString(3, user.getLastName());
            stat.setString(4, user.getUsername());
            stat.setString(5, user.getPassword());
            boolean isInserted = stat.execute();
            conn.setAutoCommit(true);
            if (!isInserted)
            {
                return "success";
            }
            else
            {
                return "failed";
            }
        }
        finally
        {
            conn.close();
        }
    }
}
