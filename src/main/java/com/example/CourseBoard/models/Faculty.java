package com.example.CourseBoard.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Faculty extends Person {
  private String office;
  private boolean tenure;
  @OneToMany(mappedBy = "author")
  @JsonIgnore
  private List<Course> authoredCourses;

  public String getOffice() {
    return office;
  }

  public void authoredCourse(Course course) {
    this.authoredCourses.add(course);
    if(course.getAuthor() != this) {
      course.setAuthor(this);
    }
  }

  public List<Course> getAuthoredCourses() {
    return this.authoredCourses;
  }

  public boolean isTenure() {
    return tenure;
  }

  public void setOffice(String office) {
    this.office = office;
  }

  public void setTenure(boolean tenure) {
    this.tenure = tenure;
  }

  public Faculty() {}

  public Faculty(String office, boolean tenure) {
    this.office = office;
    this.tenure = tenure;
  }

  public Faculty(String username, String password, String office, boolean tenure) {
    super(username, password);
    this.office = office;
    this.tenure = tenure;
    this.authoredCourses = new ArrayList<>();
  }


}
