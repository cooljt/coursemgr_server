package com.example.CourseBoard.models;

import javax.persistence.Entity;

@Entity
public class LinkWidget extends Widget{
  private String href;
  private String title;

  public LinkWidget(){}

  public LinkWidget(String href, String title) {
    this.href = href;
    this.title = title;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
