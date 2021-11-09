package com.example.web;

import com.example.domain.LoginSampleException;
import com.example.domain.models.Item;
import com.example.domain.models.Wishlist;
import com.example.domain.services.ItemService;
import com.example.domain.services.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;


@Controller
public class WishlistController {

  private WishlistService wishlistService = new WishlistService();


  // method for "Add wishlist" fields and button on "userpage"
  @PostMapping("/addWishlist")
  public String saveWishlist (WebRequest request, Model model) throws LoginSampleException {
    //Retrieve values from HTML form via WebRequest

    String wishlistName = request.getParameter("wishlistName");
    // Retrieve "email" String object from HTTP session
    String email = (String) request.getAttribute("email", WebRequest.SCOPE_SESSION);


    // Make "wishlist1" object and assign new values
    Wishlist wishlist1 = new Wishlist(wishlistName, email);

    // Work + data is delegated to login service
    wishlistService.createWishlist(wishlist1);

    // Go to page
    return "redirect:/userpage";
  }


  @GetMapping("/deleteWishlist/{wishlistName}") // GET???
  public String deleteWishlist (@PathVariable(value = "wishlistName") String wishlistName) {
    wishlistService.deleteWishlist(wishlistName);
    return "redirect:/userpage";
  }
}
