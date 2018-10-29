package com.example.CourseBoard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Module {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;

  @OneToOne
  @JsonIgnore
  private Course course;

  @OneToMany(mappedBy = "module")
  private List<Lesson> lessons;


  public void addLessons(Lesson lesson) {
    this.lessons.add(lesson);
    if(lesson.getModule() != this) {
      lesson.setModule(this);
    }
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Lesson> getLessons() {
    return lessons;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setLessons(List<Lesson> lessons) {
    this.lessons = lessons;
  }
}
