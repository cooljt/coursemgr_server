package com.example.CourseBoard.models;

public class HeadingWidget extends Widget{
  private int size;
  private String text;

  public int getSize() {
    return size;
  }

  public String getText() {
    return text;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void setText(String text) {
    this.text = text;
  }
}
