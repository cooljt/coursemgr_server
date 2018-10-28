package com.example.CourseBoard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Widget {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String type;
  private String text;
  private String items;
  private String href;
  private String src;
  private int size;
  private String orderTyep;

  @OneToOne
  @JsonIgnore
  private Topic topic;

  public String getOrderTyep() {
    return orderTyep;
  }

  public void setOrderTyep(String orderTyep) {
    this.orderTyep = orderTyep;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getText() {
    return text;
  }

  public String getItems() {
    return items;
  }

  public String getHref() {
    return href;
  }

  public String getSrc() {
    return src;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setItems(String items) {
    this.items = items;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public long getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setType(String type) {
    this.type = type;
  }
}
