package com.example.domain.services;

import com.example.domain.LoginSampleException;
import com.example.domain.models.User;
import com.example.repositories.UserRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
  private UserRepository userRepository = new UserRepository();


  public boolean checkIfUserExists(User userEntered) { // checkIfUserExistsLogin
    ResultSet rs = userRepository.dbRead();
    try {
      while (rs.next()) {
       String userTempEmail = rs.getString(1);
       String userTempPassword = rs.getString(2);
        if ((userTempEmail).equals(userEntered.getEmail())&&
            (userTempPassword).equals(userEntered.getPassword())) {
          return true;
        }
      }
    } catch (SQLException e){
      e.printStackTrace();
    }
    return false;
  }
 
  public User returnUser(User userEntered) {
    ResultSet rs = userRepository.dbRead();
    try {
      while (rs.next()) {
          /* int id = rs.getInt(1);*/
          String email = rs.getString(1);
          String password = rs.getString(2);
          String firstname = rs.getString(3);
          String lastname = rs.getString(4);
          int age = rs.getInt(5);
          String address = rs.getString(6);
          String phoneNumber = rs.getString(7);
          User user = new User(email, password, firstname, lastname, address,
              age, phoneNumber);
        if ((email).equals(userEntered.getEmail())) {
          System.out.println(userRepository.toString());
          return user;
        }
      }
    } catch(SQLException e){
      e.printStackTrace();
    }
    return null;
  }

  public void createUser(User user) throws LoginSampleException {
    userRepository.dbWrite(user);
  }

  public User findUserByEmail(String email){
   return userRepository.returnUser(email);
  }
}