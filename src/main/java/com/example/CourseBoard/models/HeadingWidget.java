package com.example.CourseBoard.models;

import javax.persistence.Entity;

@Entity
public class HeadingWidget extends Widget{
  private int size;
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public HeadingWidget(int size, String text) {
    this.size = size;
    this.text = text;
  }

  public void setHeadingWidget(HeadingWidget widget) {
    this.size = widget.size;
    this.text = widget.text;
    super.setWidget(widget);
  }

  public HeadingWidget(){}

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
