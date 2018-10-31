package com.example.CourseBoard.models;

import javax.persistence.Entity;

@Entity
public class ImageWidget extends Widget{
  private String src;

  public ImageWidget(){}

  public ImageWidget(String src) {
    this.src = src;
  }

  public void setImageWidget(ImageWidget widget) {
    this.src = widget.src;
    super.setWidget(widget);
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }
}
