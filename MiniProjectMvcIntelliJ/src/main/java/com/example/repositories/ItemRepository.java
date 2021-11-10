package com.example.repositories;

import com.example.domain.LoginSampleException;
import com.example.domain.models.Item;

import java.sql.*;


public class ItemRepository {


    public Item dbWrite(Item item) throws LoginSampleException {
      try {
        Connection con = DBManager.getConnection();
        String SQL = "INSERT INTO items (item_name, item_price, item_url, item_description, wishlist_name, user_email)" +
            " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, item.getProductName());
        ps.setString(2, item.getPrice());
        ps.setString(3, item.getUrl());
        ps.setString(4, item.getDescription());
        ps.setString(5, item.getWishlistName());
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

  public void deleteItemFromDB(int itemID){
    try {
      Connection con = DBManager.getConnection();
      String SQL = "DELETE FROM items WHERE (item_id='" + itemID + "')";
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}


