package com.example.domain.services;

import com.example.domain.LoginSampleException;
import com.example.domain.models.Item;
import com.example.repositories.ItemRepository;

import java.util.ArrayList;


public class ItemService {

  private ItemRepository itemRepository = new ItemRepository();

  public void createItem(Item item) throws LoginSampleException {
    new ItemRepository().dbWrite(item);
  }

  public ArrayList<Item> findAll(String email) {
    return itemRepository.dbRead(email);
  }



}
