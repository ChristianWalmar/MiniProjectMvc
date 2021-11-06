package com.example.domain.models;

public class Wishlist {

  private int wishlistID;
  private String wishlistEmail; // owner e-mail?
  private String wishlistUrl;
  private int wishId;

  public Wishlist(int wishlistID, String wishlistEmail, String wishlistUrl, int wishId) {
    this.wishlistID = wishlistID;
    this.wishlistEmail = wishlistEmail;
    this.wishlistUrl = wishlistUrl;
    this.wishId = wishId;
  }

  public int getWishlistID() {
    return wishlistID;
  }

  public void setWishlistID(int wishlistID) {
    this.wishlistID = wishlistID;
  }

  public String getWishlistEmail() {
    return wishlistEmail;
  }

  public void setWishlistEmail(String wishlistEmail) {
    this.wishlistEmail = wishlistEmail;
  }

  public String getWishlistUrl() {
    return wishlistUrl;
  }

  public void setWishlistUrl(String wishlistUrl) {
    this.wishlistUrl = wishlistUrl;
  }

  public int getWishId() {
    return wishId;
  }

  public void setWishId(int wishId) {
    this.wishId = wishId;
  }

  @Override
  public String toString() {
    return "Wishlist{" +
        "wishlistID=" + wishlistID +
        ", wishlistEmail='" + wishlistEmail + '\'' +
        ", wishlistUrl='" + wishlistUrl + '\'' +
        ", wishId=" + wishId +
        '}';
  }
}