package com.example.web;


import com.example.domain.LoginSampleException;

import com.example.domain.models.Item;
import com.example.domain.services.ItemService;
import com.example.domain.services.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;


@Controller
public class ItemController {

  private ItemService itemService = new ItemService();


  // method for "Add item" fields and button on "userpage"
  @PostMapping("/addItem")
  public String saveItem (WebRequest request, Model model) throws LoginSampleException {

    //Retrieve values from HTML form via WebRequest
    String productName = request.getParameter("productName");
    String price = request.getParameter("price");
    String url = request.getParameter("url");
    String description = request.getParameter("description");

   /* String wishlistName = request.getParameter("wishlistName");*/
    String wishlistName = (String) request.getAttribute("wishlistName", WebRequest.SCOPE_SESSION);
 /*     String wishlistName = "List123";*/
    // Retrieve "email" String object from HTTP session
    String email = (String) request.getAttribute("email", WebRequest.SCOPE_SESSION);


    // Make "item1" object and assign new values
    Item item1 = new Item(productName,price, url, description, wishlistName, email);

    // Work + data is delegated to login service
    itemService.createItem(item1);

    request.setAttribute("item1", item1, WebRequest.SCOPE_SESSION);

    // Call arraylist and sort the items by wishlistName
    ArrayList<Item> itemsOneList = new WishlistService().showWishlist(wishlistName);
    request.setAttribute("itemsOneList", itemsOneList, WebRequest.SCOPE_SESSION);



    //  Assign model attribute to arraylist med  items
    model.addAttribute("itemsOneList", itemsOneList);

    // Go to page
    return "redirect:/showlist";
  }


  @GetMapping("/showlist")
  public String showWishlishlist (WebRequest request, Model model) {
    Item item1 = (Item) request.getAttribute("item1", WebRequest.SCOPE_SESSION);
    model.addAttribute("item1", item1);  // ?????
    ArrayList itemsOneList = (ArrayList) request.getAttribute("itemsOneList", WebRequest.SCOPE_SESSION);
    model.addAttribute("itemsOneList", itemsOneList);  // ?????
    return "showlist";
  }

  @GetMapping("/deleteItem/{itemID}") // GET???
  public String deleteItem (@PathVariable(value = "itemID") int itemID) {
    itemService.deleteItem(itemID);
    return "redirect:/userpage"; // navigate to same page???
  }

}
