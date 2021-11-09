package com.example.domain.models;

public class Wishlist {

  private String wishlistName;
  private String wishlistOwnerEmail;

  public Wishlist(String wishlistName, String wishlistOwnerEmail) {

    this.wishlistName = wishlistName;
    this.wishlistOwnerEmail = wishlistOwnerEmail;
  }


  public String getWishlistName() {
    return wishlistName;
  }

  public void setWishlistName(String wishlistName) {
    this.wishlistName = wishlistName;
  }

  public String getWishlistOwnerEmail() {
    return wishlistOwnerEmail;
  }

  public void setWishlistOwnerEmail(String wishlistOwnerEmail) {
    this.wishlistOwnerEmail = wishlistOwnerEmail;
  }

  @Override
  public String toString() {
    return "Wishlist{" +
        "wishlistName='" + wishlistName + '\'' +
        ", wishlistOwnerEmail='" + wishlistOwnerEmail + '\'' +
        '}';
  }
}