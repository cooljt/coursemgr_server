package com.example.CourseBoard.models;

import javax.persistence.Entity;

@Entity
public class ListWidget extends Widget{
  private String items;
  private String orderType;

  public ListWidget(){}

  public ListWidget(String items, String orderType) {
    this.items = items;
    this.orderType = orderType;
  }

  public void setListWidget(ListWidget widget) {
    this.items = widget.items;
    this.orderType = widget.orderType;
  }
  
  public String getItems() {
    return items;
  }

  public void setItems(String items) {
    this.items = items;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }
}
