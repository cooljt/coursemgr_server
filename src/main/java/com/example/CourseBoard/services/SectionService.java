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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SectionService {
  @Autowired
  SectionRepository sectionRepository;
  @Autowired
  StudentRepository studentRepository;

  @PostMapping("api/section")
  public Section createSection(@RequestBody Section section) {
    return sectionRepository.save(section);
  }

  @GetMapping("api/section")
  public Iterable<Section> findAllSections() {
    return sectionRepository.findAll();
  }

  @PostMapping("api/section/{zid}/student/{sid}")
  public void enrollStudentInSection(@PathVariable("zid") int zid, @PathVariable("sid") int sid) {
    Section section = sectionRepository.findById(zid).get();
    Student student = studentRepository.findById(sid).get();
    section.enrollStudent(student);
    sectionRepository.save(section);
  }

  @GetMapping("api/section/{zid}/student")
  public Iterable<Student> findAllEnrolledStudents(@PathVariable("zid") int zid) {
    if (sectionRepository.findById(zid).isPresent()) {
      return sectionRepository.findById(zid).get().getEnrolledStudents();
    }
    return null;
  }

}
