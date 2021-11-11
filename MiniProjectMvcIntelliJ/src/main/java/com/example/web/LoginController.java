package com.example.web;

import com.example.domain.LoginSampleException;
import com.example.domain.models.Item;
import com.example.domain.models.User;
import com.example.domain.models.Wishlist;
import com.example.domain.services.ItemService;
import com.example.domain.services.LoginService;
import com.example.domain.services.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Objects;


@Controller
public class LoginController {


  private LoginService loginService = new LoginService();
  private ItemService itemService = new ItemService();
  private WishlistService wishlistService = new WishlistService();

  // main page "index"
  @GetMapping("/")
  public String index() {
    return "index";
  }


  // "signup" page
  @GetMapping("/signup")
  public String signup() {
    return "signup";
  }


  @PostMapping("/login")
  public String loginUser(HttpServletRequest request, Model model) throws LoginSampleException {

    HttpSession session = request.getSession();
    //Retrieve values from HTML form via WebRequest
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    // delegate work + data to login service
    User user = new User(email, password);
    boolean isExists = loginService.checkIfUserExists(user);

    if (Objects.equals(email, "") || Objects.equals(password, "")) {
      throw new LoginSampleException("You have to fill in all the fields...");

      /*return "redirect:/";*/
    } else {
      if (isExists) {
        // Set email in session
        session.setAttribute("email", email);

        // Go to next page after login
        return "redirect:/userpage";

      } else {
        throw new LoginSampleException("User is not exists, please try again");
        // or turn back to "index"
        /*return "redirect:/";*/
        /*throw new LoginSampleException("User could not be found in our user base ");*/
      }
    }
  }

  // users main page after login
  @GetMapping("/userpage")
  public String userPage(Model model, HttpServletRequest request) {
    HttpSession session = request.getSession();
    String emailTemp = (String) session.getAttribute("email");

    User user1 = loginService.findUserByEmail(emailTemp);


    model.addAttribute("user1", user1);

    // Call arraylist and sort the wishlists by users email
    ArrayList<Wishlist> wishlists = wishlistService.findAll(emailTemp); // search of wishlist objects by email

    //  Assign model attribute to arraylist med  items
    model.addAttribute("wishlists", wishlists);


    // Assign model attribute for "wishlist1" object
    Wishlist wishlist1 = new Wishlist();
    model.addAttribute("wishlist1", wishlist1);

    return "userpage";
  }


  // method for "Log out" button
  @GetMapping("/logout")
  public String logoutUser(HttpSession session) {
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
      if (new LoginService().checkIfUserExistsRegister(user)) {
        throw  new LoginSampleException("There was already a user with this email.");
      } else {
        loginService.createUser(user);
        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        model.addAttribute("user", user);
      }
    } else { // If passwords don't match, an exception is thrown
      throw new LoginSampleException("The two passwords did not match");
    }
    return "/index";
  }

  @ExceptionHandler(LoginSampleException.class)
  public String handleError(Model model, Exception exception) {
    model.addAttribute("message", exception.getMessage());
    return "exceptionPage";

  }
}
