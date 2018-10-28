package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Section;
import com.example.CourseBoard.models.Student;
import com.example.CourseBoard.repositories.SectionRepository;
import com.example.CourseBoard.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentService {

  @Autowired
  StudentRepository studentRepository;
  @Autowired
  SectionRepository sectionRepository;

  @GetMapping("api/student")
  public List<Student> findAllStudent() {
    return (List<Student>)studentRepository.findAll();
  }

  @PostMapping("api/student/{sid}/section/{zid}")
  public void enrollStudentInSection(@PathVariable("sid") int sid, @PathVariable("zid") int zid) {
    Section section = sectionRepository.findById(zid).get();
    Student student = studentRepository.findById(sid).get();

    student.enrollSection(section);
    studentRepository.save(student);
  }

  @GetMapping("api/student/{sid}/section")
  public Iterable<Section> findStudentEnrolledSections(@PathVariable("sid") int sid) {
    if (studentRepository.findById(sid).isPresent()) {
      Student student = studentRepository.findById(sid).get();
      return student.getEnrolledSections();
    }
    return null;
  }

}
