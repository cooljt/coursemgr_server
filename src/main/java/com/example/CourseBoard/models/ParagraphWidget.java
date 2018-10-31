package com.example.CourseBoard.models;

import javax.persistence.Entity;

@Entity
public class ParagraphWidget extends Widget{
  private String text;

  public ParagraphWidget(){}

  public void setParagraphWidget(ParagraphWidget widget) {
    this.text = widget.text;
    super.setWidget(widget);
  }

  public ParagraphWidget(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
