package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Course;
import com.example.CourseBoard.models.Lesson;
import com.example.CourseBoard.models.Module;

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
public class LessonService {
  @GetMapping("/api/module/{mid}/lesson")
  public List<Lesson> getAllLessons(@PathVariable("mid") long mid) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        if (module.getId() == mid) {
          return module.getLessons();
        }
      }
    }
    return new ArrayList<>();
  }

  @PostMapping("/api/module/{mid}/lesson")
  public List<Lesson> createLesson(@PathVariable("mid") long mid, @RequestBody Lesson lesson) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        if (module.getId() == mid) {
          module.getLessons().add(lesson);
          return module.getLessons();
        }
      }
    }
    return new ArrayList<>();
  }

  @GetMapping("/api/lesson/{lid}")
  public Lesson getLessonById(@PathVariable("lid") long lid) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        for (Lesson lesson:module.getLessons()) {
          if (lesson.getId() == lid) {
            return lesson;
          }
        }
      }
    }
    return new Lesson();
  }

  @PutMapping("/api/lesson/{lid}")
  public List<Lesson> updateLessonById(@PathVariable("lid") long lid, @RequestBody Lesson lesson) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        List<Lesson> temp = module.getLessons();
        for (int i = 0; i < temp.size(); i++) {
          if (temp.get(i).getId() == lid) {
            temp.set(i,lesson);
            return module.getLessons();
          }
        }
      }
    }
    return new ArrayList<>();
  }

  @DeleteMapping("/api/lesson/{lid}")
  public List<Lesson> deleteLesson(@PathVariable("lid") long lid) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        for (Lesson lesson:module.getLessons()) {
          if (lesson.getId() == lid) {
            module.getLessons().remove(lesson);
            return module.getLessons();
          }
        }
      }
    }
    return new ArrayList<>();
  }

}
