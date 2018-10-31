package com.example.CourseBoard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Widget {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String type;
  private int rank;

  @OneToOne
  @JsonIgnore
  private Topic topic;

  public Widget(){}

  public Widget(String type, int rank, Topic topic) {
    this.type = type;
    this.rank = rank;
    this.topic = topic;
  }

  public Topic getTopic() {
    return topic;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public void setTopic(Topic topic) {
    this.topic = topic;
  }

  public void setWidget(Widget widget) {
    this.type = widget.type;
    this.rank = widget.rank;
  }

  public long getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setType(String type) {
    this.type = type;
  }
}
