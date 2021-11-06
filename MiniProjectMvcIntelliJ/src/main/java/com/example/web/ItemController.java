package com.example.web;


import com.example.domain.LoginSampleException;

import com.example.domain.models.Item;
import com.example.domain.models.User;
import com.example.domain.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Controller
public class ItemController {

  private ItemService is = new ItemService();

  @GetMapping("/showItems")
  public String showItems(Model model, WebRequest request) {
    User user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
   /* String email = user.getEmail();*/
    List<Item> items = is.findAll(/*email*/);
    model.addAttribute("items", items);
    return "itemsuser";
  }


  /*@ModelAttribute("item")
  public Item getItem(){
    return new Item();
  }

  @PostMapping("/addItem")
  public String saveItem (@ModelAttribute ("item") Item item) throws LoginSampleException {
    is.createItem(item);
    return "redirect:/showItems";
  }*/

  @PostMapping("/addItem")
  public String saveItem (WebRequest request, Model model) throws LoginSampleException {
    //Retrieve values from HTML form via WebRequest
    String productName = request.getParameter("productName");
    String price = request.getParameter("price");
    String url = request.getParameter("url");
    String description = request.getParameter("description");
    int wishlistNumber = Integer.parseInt(request.getParameter("wishlistNumber"));
    String userEmail = request.getParameter("userEmail");
    Item item = new Item(productName,price, url, description, wishlistNumber, userEmail);

    // Work + data is delegated to login service
    is.createItem(item);

    request.setAttribute("item", item, WebRequest.SCOPE_SESSION);
    model.addAttribute("user", item);
    List<Item> items = is.findAll(/*email*/);
    model.addAttribute("items", items);

    // Go to page
    return "redirect:/showItems";
  }


  /*@GetMapping("/deleteItem/{itemID}")
  public String deleteItem (@PathVariable(value = "itemID") int itemID){
    is.deleteUser(itemID);
    return "redirect:/userLogged";
  }*/

}
