package com.example.CourseBoard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;
  private Date created;
  private Date modified;

  @ManyToOne
  @JsonIgnore
  private Faculty author;

  @OneToMany(mappedBy = "course")
  @JsonIgnore
  private List<Module> modules;


  public void setAuthor(Faculty author) {
    this.author = author;
    if(!author.getAuthoredCourses().contains(this)) {
      author.getAuthoredCourses().add(this);
    }
  }

  public void setCourse(Course course) {
    this.title = course.title;
    this.modified = course.modified;
  }

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

  public void setModules(List<Module> modules) {
    this.modules = modules;
  }

  public int getId() {
    return id;
  }

  public Faculty getAuthor() {
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