package com.example.CourseBoard.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String userType;
  private String phone;
  private String email;
  private String birth;


  public void set(Person person) {
    this.username = person.username;
    this.password = person.password;
    this.phone = person.phone;
    this.email = person.email;
  }

  public Person() {}
  public Person(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getBirth() {
    return birth;
  }

  public String getUserType() {
    return userType;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }
}
