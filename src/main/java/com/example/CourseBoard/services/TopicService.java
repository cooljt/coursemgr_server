package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Course;
import com.example.CourseBoard.models.Lesson;
import com.example.CourseBoard.models.Module;
import com.example.CourseBoard.models.Topic;

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
public class TopicService {
  @GetMapping("/api/lesson/{lid}/topic")
  public List<Topic> findAllTopics(@PathVariable("lid") long lid) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        for (Lesson lesson:module.getLessons()) {
          if (lesson.getId() == lid) {
            return lesson.getTopics();
          }
        }
      }
    }
    return new ArrayList<>();
  }

  @PostMapping("/api/lesson/{lid}/topic")
  public List<Topic> createTopic(@PathVariable("lid") long lid, @RequestBody Topic topic) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        for (Lesson lesson:module.getLessons()) {
          if (lesson.getId() == lid) {
            lesson.getTopics().add(topic);
            return lesson.getTopics();
          }
        }
      }
    }
    return new ArrayList<>();
  }

  @GetMapping("/api/topic/{tid}")
  public Topic findTopicById(@PathVariable("tid") long tid) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        for (Lesson lesson:module.getLessons()) {
          for (Topic topic:lesson.getTopics()) {
            if (topic.getId() == tid) {
              return topic;
            }
          }
        }
      }
    }
    return new Topic();
  }

  @PutMapping("/api/topic/{tid}")
  public List<Topic> updateTopicById(@PathVariable("tid") long tid, @RequestBody Topic topic) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        for (Lesson lesson:module.getLessons()) {
          List<Topic> temp = lesson.getTopics();
          for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getId() == tid) {
              temp.set(i,topic);
              return lesson.getTopics();
            }
          }
        }
      }
    }
    return new ArrayList<>();
  }

  @DeleteMapping("/api/topic/{tid}")
  public List<Topic> deleteTopic(@PathVariable("tid") long tid) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        for (Lesson lesson:module.getLessons()) {
          for (Topic topic:lesson.getTopics()) {
            if (topic.getId() == tid) {
              lesson.getTopics().remove(topic);
              return lesson.getTopics();
            }
          }
        }
      }
    }
    return new ArrayList<>();
  }
}
