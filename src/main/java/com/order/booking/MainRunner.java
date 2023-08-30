package com.order.booking;

import com.order.booking.dao.ItemsDao;
import com.order.booking.entity.Item;
import com.order.booking.service.ItemsService;

import java.sql.SQLException;

public class MainRunner {
    public static void main(String[] args) {
        ItemsService service = new ItemsService();


        Item item = new Item();
        item.setItemId(500);
        item.setItem("Pen");
        item.setQuantity(20);
        item.setDescription("Something");
        item.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Ash_Tree_-_geograph.org.uk_-_590710.jpg/220px-Ash_Tree_-_geograph.org.uk_-_590710.jpg");
        item.setPrice(50);


        try {
       System.out.println("Item Result:: "+service.save(item));
         //System.out.println("Find All Result:: " + service.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
