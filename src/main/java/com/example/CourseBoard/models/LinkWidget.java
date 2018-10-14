package com.example.CourseBoard.models;

public class LinkWidget extends Widget{
  private String type;
  private String href;

  public String getType() {
    return type;
  }

  public String getHref() {
    return href;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setHref(String href) {
    this.href = href;
  }
}
