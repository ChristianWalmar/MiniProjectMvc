package com.example.web;

import com.example.domain.LoginSampleException;
import com.example.domain.models.User;
import com.example.domain.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

  //Inversion of Control
  private LoginService loginService = new LoginService();

  @GetMapping("/")
  public String index (){
    return "index";
  }

  @GetMapping("/signup")
  public String signup (){
    return "signup";
  }

    @PostMapping("/login")
  public String loginUser(WebRequest request, Model model) {

    //Retrieve values from HTML form via WebRequest
    String email = request.getParameter("email");
    String password = request.getParameter("password");


    // delegate work + data to login service

    User user = new User(email, password);
    boolean isExists = loginService.checkIfUserExists(user);



    // Set user in session
    if (isExists) {
      User user1 = loginService.returnUser(user);
      request.setAttribute("user1", user1, WebRequest.SCOPE_SESSION);
      model.addAttribute("user1", user1);
      return "/userpage";

    } else {

      return "redirect:/";
      /*throw new LoginSampleException("User could not be found in our user base ");*/
    }
  }

  @GetMapping("/userpage")
  public String userPage (){
    return "userpage";
  }


  @GetMapping("/logout")
  public String logoutUser (HttpSession session){
    session.invalidate();
    return "redirect:/";
  }


  @PostMapping("/register")
  public String createUser(WebRequest request, Model model) throws LoginSampleException {
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
      User user = new User(email, password1, firstName, lastName, address, age, phoneNumber);
      loginService.createUser(user);
      request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
      model.addAttribute("user", user);



      return "/index";



    } else { // If passwords don't match, an exception is thrown
      throw new LoginSampleException("The two passwords did not match");
    }
  }

}
