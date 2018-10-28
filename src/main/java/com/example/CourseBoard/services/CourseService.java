package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Course;
import com.example.CourseBoard.models.Faculty;
import com.example.CourseBoard.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseService {
    public static List<Course> courses = new ArrayList<Course>();
    @Autowired
    CourseRepository courserRepository;

  @GetMapping("api/courses")
  public List<Course> findAllCourses() {
    return (List<Course>)courserRepository.findAll();
  }

  @GetMapping("api/course/{cid}/author")
  public Faculty findCourseAuthor(@PathVariable("cid") int cid) {
    Course course = courserRepository.findById(cid).get();
    return course.getAuthor();
  }

  @PostMapping("api/course")
  public Course createCourse(@RequestBody Course course) {
    return courserRepository.save(course);
  }

  @DeleteMapping("api/course/{courseId}")
  public void deleteCourse(@PathVariable("courseId") int id) {
    courserRepository.deleteById(id);
  }

  @GetMapping("api/course/{courseId}")
  public Course findCourseById(@PathVariable("courseId") int id) {
    return courserRepository.findById(id).get();
  }

  @PutMapping("api/course/{courseId}")
  public Course updateCourseById(@PathVariable("courseId") int id, @RequestBody Course course) {
    Course c = courserRepository.findById(id).get();
    c.setCourse(course);
    return courserRepository.save(c);
  }
}
