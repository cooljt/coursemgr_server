package com.example.CourseBoard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Section {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @ManyToMany(mappedBy = "enrolledSections")
  @JsonIgnore
  private List<Student> enrolledStudents;


  public void enrollStudent(Student student) {
    this.enrolledStudents.add(student);
    if(!student.getEnrolledSections().contains(this)) {
      student.getEnrolledSections().add(this);
    }
  }

  public Section(String name, List<Student> enrolledStudents) {
    this.name = name;
    this.enrolledStudents = enrolledStudents;
  }

  public Section(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Student> getEnrolledStudents() {
    return enrolledStudents;
  }

  public void setEnrolledStudents(List<Student> enrolledStudents) {
    this.enrolledStudents = enrolledStudents;
  }
}
