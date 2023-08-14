package com.order.booking.service;

import com.order.booking.dao.CustomerDao;
import com.order.booking.entity.Customer;
import java.sql.SQLException;

public class CustomerService
{
        private CustomerDao customerDao;
    public CustomerService()
        {
            customerDao = new CustomerDao();
        }
        public Customer login(String username, String password) throws SQLException
        {
            return customerDao.login(username,password);
        }
        public String save(Customer customer) throws SQLException
        {
            return customerDao.save(customer);
        }

}
