package com.example.CourseBoard.models;

public class ListWidget extends Widget{
  private String orderTyep;
  private String items;

  public String getOrderTyep() {
    return orderTyep;
  }

  public String getItems() {
    return items;
  }

  public void setOrderTyep(String orderTyep) {
    this.orderTyep = orderTyep;
  }

  public void setItems(String items) {
    this.items = items;
  }
}
