package com.example.CourseBoard.models;

import javax.persistence.Entity;

@Entity
public class ListWidget extends Widget{
  private String items;
  private String orderTyep;

  public ListWidget(){}

  public ListWidget(String items, String orderTyep) {
    this.items = items;
    this.orderTyep = orderTyep;
  }

  public String getItems() {
    return items;
  }

  public void setItems(String items) {
    this.items = items;
  }

  public String getOrderTyep() {
    return orderTyep;
  }

  public void setOrderTyep(String orderTyep) {
    this.orderTyep = orderTyep;
  }
}
