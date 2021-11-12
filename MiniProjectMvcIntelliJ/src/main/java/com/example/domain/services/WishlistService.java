package com.example.domain.services;

import com.example.domain.LoginSampleException;
import com.example.domain.models.Item;
import com.example.domain.models.Wishlist;
import com.example.repositories.WishlistRepository;

import java.util.ArrayList;

public class WishlistService {

    private WishlistRepository wishlistRepository = new WishlistRepository();

    public void createWishlist(Wishlist wishlist) throws LoginSampleException {
        wishlistRepository.dbWrite(wishlist);
    }


    public ArrayList<Wishlist> findAll(String email) {
        return wishlistRepository.dbRead(email);
    }


    public void deleteWishlist(String wishlistName) {
        wishlistRepository.deleteWishlistFromDB(wishlistName);
    }

    public ArrayList<Item> showWishlist(String wishlistName) {
        return wishlistRepository.dbReadOneList(wishlistName);
    }
}
