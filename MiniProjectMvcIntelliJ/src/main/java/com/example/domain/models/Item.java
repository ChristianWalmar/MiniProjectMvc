package com.example.domain.models;

public class Item {

  private String title;
  private String colour; // may be Enum?
  private int amount;



  public Item(String title, String colour, int amount) {
    this.title = title;
    this.colour = colour;
    this.amount = amount;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Item{" +
        "title='" + title + '\'' +
        ", colour='" + colour + '\'' +
        ", amount=" + amount +
        '}';
  }
}
