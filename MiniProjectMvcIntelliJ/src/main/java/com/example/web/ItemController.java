package com.example.web;


import com.example.domain.LoginSampleException;

import com.example.domain.models.Item;
import com.example.domain.models.User;
import com.example.domain.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


import java.util.ArrayList;



@Controller
public class ItemController {

  private ItemService is = new ItemService();




  /*@ModelAttribute("item")
  public Item getItem(){
    return new Item();
  }

  @PostMapping("/addItem")
  public String saveItem (@ModelAttribute ("item") Item item) throws LoginSampleException {
    is.createItem(item);
    return "redirect:/showItems";
  }*/


  // method for "Add item" fields and button on "userpage"
  @PostMapping("/addItem")
  public String saveItem (WebRequest request, Model model) throws LoginSampleException {

    //Retrieve values from HTML form via WebRequest
    String productName = request.getParameter("productName");
    String price = request.getParameter("price");
    String url = request.getParameter("url");
    String description = request.getParameter("description");

    String wishlistNr = request.getParameter("wishlistNumber");
    int wishlistNumber = Integer.parseInt(wishlistNr);

    String userEmail = request.getParameter("userEmail");

    // Retrieve "item1" object from HTTP session and assign new values

    Item item1 = new Item(productName,price, url, description, wishlistNumber, userEmail);

    // Work + data is delegated to login service
    is.createItem(item1);

    // Go to page
    return "redirect:/showItems";
  }

  // page show items for user, sorted by e-mail
  @GetMapping("/showItems")
  public String showItems(Model model, WebRequest request) {
    User user = (User) request.getAttribute("user1", WebRequest.SCOPE_SESSION);
    String email = user.getEmail();
    ArrayList<Item> items = is.findAll(email);
    model.addAttribute("items", items);
    return "/itemsuser";
  }


  /*@GetMapping("/deleteItem/{itemID}")
  public String deleteItem (@PathVariable(value = "itemID") int itemID){
    is.deleteUser(itemID);
    return "redirect:/userLogged";
  }*/

}
