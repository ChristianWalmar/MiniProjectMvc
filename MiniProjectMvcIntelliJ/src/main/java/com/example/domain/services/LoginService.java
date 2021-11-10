package com.example.domain.services;

import com.example.domain.LoginSampleException;
import com.example.domain.models.User;
import com.example.repositories.UserRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {


  private final UserRepository userRepository = new UserRepository();

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

  public void createUser(User user) throws LoginSampleException {
    userRepository.dbWrite(user);
  }

  public User findUserByEmail(String email){
   return userRepository.returnUserByEmail(email);
  }
}