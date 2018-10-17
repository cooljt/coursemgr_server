package com.example.CourseBoard.models;

import java.util.Date;
import java.util.List;

public class Course {
  private long id;
  private String title;
  private Date created;
  private Date modified;
  private String author;
  private List<Module> modules;

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setId(long id) {
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

  public void setModules(List<Module> modules) {
    this.modules = modules;
  }

  public long getId() {
    return id;
  }

  public String getAuthor() {
    return author;
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

  public List<Module> getModules() {
    return modules;
  }
}