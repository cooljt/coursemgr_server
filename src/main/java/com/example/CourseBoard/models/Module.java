package com.example.CourseBoard.models;

import java.util.List;

public class Module {
  private long id;
  private String title;
  private List<Lesson> lessons;

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Lesson> getLessons() {
    return lessons;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setLessons(List<Lesson> lessons) {
    this.lessons = lessons;
  }
}
