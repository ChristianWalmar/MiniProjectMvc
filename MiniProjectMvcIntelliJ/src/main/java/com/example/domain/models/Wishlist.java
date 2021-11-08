package com.example.domain.models;

public class Wishlist {

  private int wishlistNumber;
  private String wishlistName;

  public Wishlist(int wishlistNumber, String wishlistName) {
    this.wishlistNumber = wishlistNumber;
    this.wishlistName = wishlistName;
  }

  public int getWishlistNumber() {
    return wishlistNumber;
  }

  public void setWishlistNumber(int wishlistNumber) {
    this.wishlistNumber = wishlistNumber;
  }

  public String getWishlistName() {
    return wishlistName;
  }

  public void setWishlistName(String wishlistName) {
    this.wishlistName = wishlistName;
  }

  @Override
  public String toString() {
    return "Wishlist{" +
        "wishlistNumber=" + wishlistNumber +
        ", wishlistName='" + wishlistName + '\'' +
        '}';
  }
}