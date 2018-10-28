package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Course;
import com.example.CourseBoard.models.Faculty;
import com.example.CourseBoard.models.HeadingWidget;
import com.example.CourseBoard.models.Lesson;
import com.example.CourseBoard.models.Module;
import com.example.CourseBoard.models.ParagraphWidget;
import com.example.CourseBoard.models.Topic;
import com.example.CourseBoard.models.Person;
import com.example.CourseBoard.models.Widget;
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
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseService {
    public static List<Course> courses = new ArrayList<Course>();
    @Autowired
    CourseRepository courserRepository;

  @GetMapping("api/courses/{author}")
  public List<Course> findAllCourses(@PathVariable("author") String author) {
    List<Course> ownedCourses = new ArrayList<>();
    for (Course course:courses) {
      if (course.getAuthor().equals(author)) {
        ownedCourses.add(course);
      }
    }
    return ownedCourses;
  }

  @GetMapping("api/course/{cid}/author")
  public Faculty findCourseAuthor(@PathVariable("cid") int cid) {
    Course course = courserRepository.findById(cid).get();
    return course.getAuthor();
  }

  @PostMapping("api/course")
  public Course createCourse(@RequestBody Course course) {
    /*courses.add(course);*/
    return courserRepository.save(course);
  }

  @DeleteMapping("api/course/{courseId}")
  public List<Course> deleteCourse(@PathVariable("courseId") long id) {
    for (Course c:courses) {
      if (c.getId() == id) {
        courses.remove(c);
        return courses;
      }
    }
    return courses;
  }

  @GetMapping("api/course/{courseId}")
  public Course findCourseById(@PathVariable("courseId") long id) {
    for (Course course:courses) {
      if (course.getId() == id) {
        return course;
      }
    }
    return null;
  }

  @PutMapping("api/course/{courseId}")
  public List<Course> updateCourseById(@PathVariable("courseId") long id, @RequestBody Course course) {
    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getId() == id) {
        courses.set(i, course);
        return courses;
      }
    }
    return courses;
  }
}
