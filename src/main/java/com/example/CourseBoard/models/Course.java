package com.example.CourseBoard.models;

import java.util.Date;

public class Course {
  private int id;
  private String title;
  private Date created;
  private Date modified;

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Date getCreated() {
    return created;
  }

  public Date getModified() {
    return modified;
  }
}