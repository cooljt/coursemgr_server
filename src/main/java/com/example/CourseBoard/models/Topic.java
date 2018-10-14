package com.example.CourseBoard.models;

import java.util.List;

public class Topic {
  private long id;
  private String title;
  private List<Widget> widgets;

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Widget> getWidgets() {
    return widgets;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setWidgets(List<Widget> widgets) {
    this.widgets = widgets;
  }
}
