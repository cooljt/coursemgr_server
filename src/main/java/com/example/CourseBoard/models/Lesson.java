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
public class Lesson {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;

  @OneToMany(mappedBy = "lesson")
  private List<Topic> topics;

  @OneToOne
  @JsonIgnore
  private Module module;

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Topic> getTopics() {
    return topics;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setTopics(List<Topic> topics) {
    this.topics = topics;
  }
}
