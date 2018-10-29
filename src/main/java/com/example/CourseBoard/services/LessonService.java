package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Lesson;
import com.example.CourseBoard.models.Module;
import com.example.CourseBoard.repositories.LessonRepository;
import com.example.CourseBoard.repositories.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonService {

  @Autowired
  ModuleRepository moduleRepository;
  @Autowired
  LessonRepository lessonRepository;


  @GetMapping("/api/module/{mid}/lesson")
  public List<Lesson> getAllLessons(@PathVariable("mid") int mid) {
    return moduleRepository.findById(mid).get().getLessons();
  }

  @PostMapping("/api/module/{mid}/lesson")
  public Lesson createLesson(@PathVariable("mid") int mid, @RequestBody Lesson lesson) {
    Module module = moduleRepository.findById(mid).get();
    Lesson l = lessonRepository.save(lesson);
    module.addLessons(l);
    l.setModule(module);
    moduleRepository.save(module);
    return lessonRepository.save(l);
  }

  @GetMapping("/api/lesson/{lid}")
  public Lesson getLessonById(@PathVariable("lid") int lid) {
    return lessonRepository.findById(lid).get();
  }

  @PutMapping("/api/lesson/{lid}")
  public Lesson updateLessonById(@PathVariable("lid") int lid, @RequestBody Lesson lesson) {
    Lesson l = lessonRepository.findById(lid).get();
    l.setTitle(lesson.getTitle());
    return lessonRepository.save(l);
  }

  @DeleteMapping("/api/lesson/{lid}")
  public void deleteLesson(@PathVariable("lid") int lid) {
    lessonRepository.deleteById(lid);
  }

}
