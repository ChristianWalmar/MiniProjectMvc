package com.example.domain.models;

public class Item {

  private int itemID;
  private String productName;
  private String price;
  private String url;
  private String description;
  private String wishlistName;
  private String userEmail;

  public Item(int itemID, String productName, String price, String url, String description, String wishlistName, String userEmail) {
    this.itemID = itemID;
    this.productName = productName;
    this.price = price;
    this.url = url;
    this.description = description;
    this.wishlistName = wishlistName;
    this.userEmail = userEmail;
  }

  public Item(String productName, String price, String url, String description, String wishlistName, String userEmail) {
    this.productName = productName;
    this.price = price;
    this.url = url;
    this.description = description;
    this.wishlistName = wishlistName;
    this.userEmail = userEmail;
  }

  public Item(){}

  public int getItemID() {
    return itemID;
  }

  public void setItemID(int itemID) {
    this.itemID = itemID;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getWishlistName() {
    return wishlistName;
  }

  public void setWishlistName(String wishlistName) {
    this.wishlistName = wishlistName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  @Override
  public String toString() {
    return "Item{" +
        "itemID=" + itemID +
        ", productName='" + productName + '\'' +
        ", price='" + price + '\'' +
        ", url='" + url + '\'' +
        ", description='" + description + '\'' +
        ", wishlistName=" + wishlistName +
        ", userEmail='" + userEmail + '\'' +
        '}';
  }
}