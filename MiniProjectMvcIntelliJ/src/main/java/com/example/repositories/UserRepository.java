package com.example.repositories;

import com.example.domain.LoginSampleException;
import com.example.domain.models.Item;
import com.example.domain.models.User;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository {

  /*public User login(String email, String password) throws LoginSampleException {
    try {
      Connection con = DBManager.getConnection();
      String SQL = "SELECT id, role FROM Users "
          + "WHERE email = ? AND password = ?";
      PreparedStatement ps = con.prepareStatement(SQL);
      ps.setString(1, email);
      ps.setString(2, password);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        String role = rs.getString("role");
        int id = rs.getInt("id");
        User user = new User(email, password);
        user.setId(id);
        return user;
      } else {
        throw new LoginSampleException("Could not validate user");
      }
    } catch (SQLException ex) {
      throw new LoginSampleException(ex.getMessage());
    }
  }*/

  public ResultSet dbRead() {
    ResultSet resSet = null;
    String select = "SELECT email, password, first_name, last_name, age, address, phone_number FROM users";
    try {
      PreparedStatement ps = DBManager.getConnection().prepareStatement(select);
      resSet = ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return resSet;
  }


  public void dbWrite(User user) throws LoginSampleException {
    try {
      Connection con = DBManager.getConnection();
      String SQL = "INSERT INTO users (email, password, first_name, last_name, address, age, phone_number)" +
          " VALUES (?, ?, ?, ?, ?, ?, ?)";
      PreparedStatement ps = con.prepareStatement(SQL/*, Statement.RETURN_GENERATED_KEYS*/);
      ps.setString(1, user.getEmail());
      ps.setString(2, user.getPassword());
      ps.setString(3, user.getFirstName());
      ps.setString(4, user.getLastName());
      ps.setString(5, user.getAddress());
      ps.setInt(6, user.getAge());
      ps.setString(7, user.getPhoneNumber());
      ps.executeUpdate();
      ResultSet ids = ps.getGeneratedKeys();
      ids.next();
      int id = ids.getInt(1);
      user.setId(id);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public User returnUser(String email) {
    System.out.println(email);
    User tmp = new User();
    try {
      Connection con = DBManager.getConnection();
      String SQL = "SELECT * FROM users WHERE (email='" + email + "')";
      PreparedStatement ps = con.prepareStatement(SQL);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        tmp.setId(rs.getInt(1));
        tmp.setEmail(rs.getString(2));
        tmp.setPassword(rs.getString(3));
        tmp.setFirstName(rs.getString(4));
        tmp.setLastName(rs.getString(5));
        tmp.setAge(rs.getInt(6));
        tmp.setAddress(rs.getString(7));
        tmp.setPhoneNumber(rs.getString(8));
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return tmp;
  }

}
