package com.example.CourseBoard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student extends Person{
  private float gpa;
  private int graduationYear;

  @ManyToMany
  @JoinTable(name="ENROLLMENT", joinColumns = @JoinColumn(name="STUDENT_ID",referencedColumnName = "ID"),
          inverseJoinColumns = @JoinColumn(name="SECTION_ID",referencedColumnName = "ID"))
  @JsonIgnore
  private List<Section> enrolledSections;

  public Student(){}

  public Student(float gpa, int graduationYear) {
    this.gpa = gpa;
    this.graduationYear = graduationYear;
  }

  public Student(String username, String password, float gpa, int graduationYear) {
    super(username, password);
    this.gpa = gpa;
    this.graduationYear = graduationYear;
  }


  public void enrollSection(Section section) {
    this.enrolledSections.add(section);
    if(!section.getEnrolledStudents().contains(this)) {
      section.getEnrolledStudents().add(this);
    }
  }

  public List<Section> getEnrolledSections() {
    return enrolledSections;
  }

  public void setEnrolledSections(List<Section> enrolledSections) {
    this.enrolledSections = enrolledSections;
  }

  public float getGpa() {
    return gpa;
  }

  public int getGraduationYear() {
    return graduationYear;
  }


  public void setGpa(float gpa) {
    this.gpa = gpa;
  }

  public void setGraduationYear(int graduationYear) {
    this.graduationYear = graduationYear;
  }
}
