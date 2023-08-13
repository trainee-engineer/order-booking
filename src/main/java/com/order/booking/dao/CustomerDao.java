package com.order.booking.dao;

import com.order.booking.config.DatabaseUtils;
import com.order.booking.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class CustomerDao
    {
        private DatabaseUtils databaseUtils;

        public CustomerDao()
        {
            try
            {
                databaseUtils = new DatabaseUtils();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }

        public Customer login(String username, String password) throws SQLException
        {
            Connection conn = databaseUtils.getConnection();
            try
            {
                //update customer set password=? where email=?
                PreparedStatement statement = conn.prepareStatement("select * from customer where username=? and password=?");
                statement.setString(1, username);
                statement.setString(2, password);



                ResultSet rs = statement.executeQuery();
                if (rs.next())
                {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt(1));
                    customer.setFirstName(rs.getString(2));
                    customer.setLastName(rs.getString(3));
                    customer.setPhone(rs.getLong(4));
                    customer.setUsername(rs.getString(5));
                    customer.setPassword(rs.getString(6));
                    customer.setConfirmPassword(rs.getString(7));
                    if (password.equals(customer.getPassword()))
                    {
                        return customer;
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

        public String save(Customer customer) throws SQLException
        {
            Connection conn = databaseUtils.getConnection();
            try
            {
                conn.setAutoCommit(false);
                PreparedStatement stat = conn.prepareStatement("insert into customer values(?,?,?,?,?,?)");
                stat.setInt(1, customer.getId());
                stat.setString(2, customer.getFirstName());
                stat.setString(3, customer.getLastName());
                stat.setLong(4, customer.getPhone());
                stat.setString(5, customer.getUsername());
                stat.setString(6, customer.getPassword());
                stat.setString(7, customer.getConfirmPassword());
                boolean isInserted = stat.execute();
                conn.setAutoCommit(true);
                if (!isInserted)
                {
                    return "successful";
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

