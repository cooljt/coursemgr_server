package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Course;
import com.example.CourseBoard.models.Faculty;
import com.example.CourseBoard.repositories.CourseRepository;
import com.example.CourseBoard.repositories.FacultyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class FacultyService {

  @Autowired
  FacultyRepository facultyRepository;
  @Autowired
  CourseRepository courseRepository;

  @GetMapping("api/faculty")
  public List<Faculty> findAllFacult() {
    return (List<Faculty>)facultyRepository.findAll();
  }

  @PutMapping("api/faculty/{fid}/authored/{cid}")
  public void authoredCourse(@PathVariable("fid") int fid, @PathVariable("cid") int cid) {
    Faculty faculty = facultyRepository.findById(fid).get();
    Course course = courseRepository.findById(cid).get();
    course.setAuthor(faculty);
    courseRepository.save(course);
    faculty.authoredCourse(course);
    facultyRepository.save(faculty);
  }


  @GetMapping("/api/faculty/{fid}/authored")
  public Iterable<Course> findAuthoredCourses(@PathVariable("fid") int fid) {
    Faculty faculty = facultyRepository.findById(fid).get();
    return faculty.getAuthoredCourses();
  }

}
