package com.example.CourseBoard.models;

import java.util.List;

public class Lesson {
  private long id;
  private String title;
  private List<Topic> topics;

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Topic> getTopics() {
    return topics;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setTopics(List<Topic> topics) {
    this.topics = topics;
  }
}
