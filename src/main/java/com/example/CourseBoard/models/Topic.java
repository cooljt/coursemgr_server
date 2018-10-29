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
public class Topic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;

  @OneToMany(mappedBy = "topic")
  private List<Widget> widgets;

  @OneToOne
  @JsonIgnore
  private Lesson lesson;

  public Lesson getLesson() {
    return lesson;
  }

  public void setLesson(Lesson lesson) {
    this.lesson = lesson;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Widget> getWidgets() {
    return widgets;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setWidgets(List<Widget> widgets) {
    this.widgets = widgets;
  }
}
