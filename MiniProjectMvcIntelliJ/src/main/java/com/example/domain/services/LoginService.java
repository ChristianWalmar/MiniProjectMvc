package com.example.domain.services;

import com.example.domain.LoginSampleException;
import com.example.domain.models.User;
import com.example.repositories.UserRepository;

public class LoginService {
  private UserRepository userRepository = null;



  // Dependency injection
  public LoginService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User login(String email, String password) throws LoginSampleException {
    return userRepository.login(email, password);
  }

  public User createUser(int id, String email, String password, String firstName, String lastName, String address, int age,
                         String phoneNumber) throws LoginSampleException {
    // By default, new users are customers
    User user = new User(id, email, password, firstName, lastName, address, age, phoneNumber);
    return userRepository.createUser(user);
  }
}