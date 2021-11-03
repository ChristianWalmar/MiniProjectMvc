package com.example.web;

import com.example.domain.LoginSampleException;
import com.example.domain.models.User;
import com.example.domain.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {

  //Inversion of Control
  private LoginService loginService = new LoginService();

  @GetMapping("/")
  public String index (){
    return "index";
  }

  @PostMapping("/login")
  public String loginUser(WebRequest request) throws LoginSampleException {

    //Retrieve values from HTML form via WebRequest
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    // delegate work + data to login controller
    User user = loginService.login(email, password);

    // Set user and role in session
    request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
  /*  request.setAttribute("role", user.getRole(), WebRequest.SCOPE_SESSION);*/

    return "userpages/";
  }


  @PostMapping("/register")
  public String createUser(WebRequest request) throws LoginSampleException {
    //Retrieve values from HTML form via WebRequest
    String email = request.getParameter("email");
    String password1 = request.getParameter("password1");
    String password2 = request.getParameter("password2");
    String firstName = request.getParameter("firstname");
    String lastName = request.getParameter("lastname");
    String address = request.getParameter("address");
    int age = Integer.parseInt(request.getParameter("age"));
    String phoneNumber = request.getParameter("phonenumber");

    // If passwords match, work + data is delegated to login service
    if (password1.equals(password2)) {
      User user = loginService.createUser(email, password1, firstName, lastName, address,
          age, phoneNumber);
      request.setAttribute("user", user, WebRequest.SCOPE_SESSION);

      return "index";

    } else { // If passwords don't match, an exception is thrown
      throw new LoginSampleException("The two passwords did not match");
    }
  }

}
