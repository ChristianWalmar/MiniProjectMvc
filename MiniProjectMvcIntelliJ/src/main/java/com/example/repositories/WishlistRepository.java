package com.example.repositories;

import com.example.domain.LoginSampleException;
import com.example.domain.models.Wishlist;

import java.sql.*;
import java.util.ArrayList;

public class WishlistRepository {

  public ArrayList<Wishlist> dbRead(String email) {
    ArrayList<Wishlist> wishlistsTemp = new ArrayList<>();
    Wishlist tmp = null;
    try {
      Connection con = DBManager.getConnection();
      String SQL = "SELECT * FROM wishlists WHERE (wishlist_owner_email='" + email + "')";
      PreparedStatement ps = con.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        tmp = new Wishlist(rs.getString(1),
            rs.getString(2));

        wishlistsTemp.add(tmp);
      }

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return wishlistsTemp;
  }



  public Wishlist dbWrite(Wishlist wishlist) throws LoginSampleException {
    try {
      Connection con = DBManager.getConnection();
      String SQL = "INSERT INTO wishlists (wishlist_name, wishlist_owner_email)" +
          " VALUES (?, ?)";
      PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, wishlist.getWishlistName());
      ps.setString(2, wishlist.getWishlistOwnerEmail());
      ps.executeUpdate();
      ResultSet ids = ps.getGeneratedKeys();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return wishlist;
  }

  public void deleteWishlistFromDB(String wishlistName){
    try {
      Connection con = DBManager.getConnection();
      String SQL = "DELETE FROM wishlists WHERE (wishlist_name='" + wishlistName + "')";
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
