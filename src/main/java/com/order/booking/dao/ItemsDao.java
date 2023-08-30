package com.order.booking.dao;

import com.order.booking.config.DatabaseUtils;
import com.order.booking.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsDao {
    private DatabaseUtils databaseUtils = DatabaseUtils.getInstance();


    public String save(Item item) throws SQLException {
        Connection conn = databaseUtils.getConnection();
        try {
            conn.setAutoCommit(false);
            PreparedStatement stat = conn.prepareStatement("insert into items values(?,?,?,?,?,?)");
            stat.setInt(1, item.getItemId());
            stat.setString(2, item.getItemName());
            stat.setInt(3, item.getQuantity());
            stat.setDouble(4, item.getPrice());
            stat.setString(5, item.getUrl());
            stat.setString(6, item.getDescription());

            boolean isInserted = stat.execute();
            conn.setAutoCommit(true);
            if (!isInserted) {
                return "successful";
            } else {
                return "failed";
            }
        } finally {
            conn.close();
        }
    }

    public List<Item> findAll() {
        try {
            Connection connection = databaseUtils.getConnection();
            PreparedStatement state = connection.prepareStatement("select * from items");
            ResultSet rs = state.executeQuery();
            List<Item> list = new ArrayList<>();
            if (rs.next()) {
                do {
                    Item item = new Item
                            (rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getDouble(4),
                            rs.getString(5),
                            rs.getString(6));
                    list.add(item);
                } while (rs.next());
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

