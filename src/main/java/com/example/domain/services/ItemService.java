package com.example.domain.services;

import com.example.domain.LoginSampleException;
import com.example.domain.models.Item;
import com.example.repositories.ItemRepository;

public class ItemService {

    private ItemRepository itemRepository = new ItemRepository();

    public void createItem(Item item) throws LoginSampleException {
        new ItemRepository().dbWrite(item);
    }


    public void deleteItem(int itemID) {
        itemRepository.deleteItemFromDB(itemID);
    }

}
