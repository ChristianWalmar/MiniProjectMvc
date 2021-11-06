package com.example.repositories;

import com.example.domain.LoginSampleException;
import com.example.domain.models.Item;

import java.sql.*;
import java.util.ArrayList;



public class ItemRepository {

  public ArrayList<Item> dbRead(/*String email*/) {
    ArrayList<Item> itemsTemp = new ArrayList<>();
    Item tmp = null;
    try {
      Connection con = DBManager.getConnection();
      String SQL = "SELECT * FROM items";
      /* String SQL = "SELECT * FROM items WHERE (user_email='" + email + "')";*/
      PreparedStatement ps = con.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        tmp = new Item(rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getString(7));
        itemsTemp.add(tmp);
      }

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return itemsTemp;
  }



    public Item dbWrite(Item item) throws LoginSampleException {
      try {
        Connection con = DBManager.getConnection();
        String SQL = "INSERT INTO items (item_name, item_price, item_url, item_description, wishlist_number, user_email)" +
            " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, item.getProductName());
        ps.setString(2, item.getPrice());
        ps.setString(3, item.getUrl());
        ps.setString(4, item.getDescription());
        ps.setInt(5, item.getWishlistNumber());
        ps.setString(6, item.getUserEmail());
        ps.executeUpdate();
        ResultSet ids = ps.getGeneratedKeys();
        ids.next();
        int id = ids.getInt(1);
        item.setItemID(id);
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      return item;
    }
}


