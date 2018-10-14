package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseService {
  List<Course> courses = new ArrayList<>();

  @GetMapping("api/courses")
  public List<Course> findAllCourses() {
    return courses;
  }
}
