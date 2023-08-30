package com.order.booking.service;

import com.order.booking.dao.CustomerDao;
import com.order.booking.dao.ItemsDao;
import com.order.booking.entity.Customer;
import com.order.booking.entity.Item;

import java.sql.SQLException;
import java.util.List;

public class ItemsService
{
        private ItemsDao itemsDao;
    public ItemsService()
        {
            itemsDao = new ItemsDao();
        }

        public String save(Item item) throws SQLException
        {
            return itemsDao.save(item);
        }
        public List<Item>findAll(){
        return itemsDao.findAll();
        }

}
