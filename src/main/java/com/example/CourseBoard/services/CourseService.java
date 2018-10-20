package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Course;
import com.example.CourseBoard.models.HeadingWidget;
import com.example.CourseBoard.models.Lesson;
import com.example.CourseBoard.models.Module;
import com.example.CourseBoard.models.ParagraphWidget;
import com.example.CourseBoard.models.Topic;
import com.example.CourseBoard.models.Person;
import com.example.CourseBoard.models.Widget;

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
    public static List<Course> courses = new ArrayList<Course>(){{
    HeadingWidget w1 = new HeadingWidget();
    ParagraphWidget w2 = new ParagraphWidget();
    w1.setId(1);
    w1.setType("HEADING");
    w1.setSize(1);
    w1.setText("The Document Object Model");
    w2.setId(2);
    w2.setType("PARAGRAPH");
    w2.setText("This topic introduces the DOM");
    List<Widget> widgets = new ArrayList<Widget>(){{
      add(w1);
      add(w2);
    }};

    Topic t1 = new Topic();
    t1.setId(3);
    t1.setTitle("DOM");
    t1.setWidgets(widgets);
    List<Topic> topics = new ArrayList<Topic>(){{add(t1);}};

    Lesson l1 = new Lesson();
    l1.setId(4);
    l1.setTitle("HTML");
    l1.setTopics(topics);
    List<Lesson> lessons = new ArrayList<Lesson>(){{add(l1);}};

    Module m1 = new Module();
    m1.setId(5);
    m1.setTitle("Week 1");
    m1.setLessons(lessons);
    List<Module> modules = new ArrayList<Module>(){{add(m1);}};

    Course c1 = new Course();
    c1.setId(6);
    c1.setTitle("CS 5610");
    c1.setAuthor("Ti");
    c1.setCreated(new Date(new Date().getTime()));
    c1.setModified(new Date(new Date().getTime()));
    c1.setModules(modules);
    add(c1);
  }};

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

  @PostMapping("api/course")
  public List<Course> createCourse(@RequestBody Course course) {
    courses.add(course);
    return courses;
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
