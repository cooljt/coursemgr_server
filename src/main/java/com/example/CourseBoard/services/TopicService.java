package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Lesson;
import com.example.CourseBoard.models.Topic;
import com.example.CourseBoard.repositories.LessonRepository;
import com.example.CourseBoard.repositories.TopicRepository;

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
public class TopicService {

  @Autowired
  LessonRepository lessonRepository;
  @Autowired
  TopicRepository topicRepository;

  @GetMapping("/api/lesson/{lid}/topic")
  public List<Topic> findAllTopics(@PathVariable("lid") int lid) {
    Lesson lesson = lessonRepository.findById(lid).get();
    return lesson.getTopics();
  }

  @PostMapping("/api/lesson/{lid}/topic")
  public Topic createTopic(@PathVariable("lid") int lid, @RequestBody Topic topic) {
    Lesson lesson = lessonRepository.findById(lid).get();
    Topic t = topicRepository.save(topic);
    lesson.addTopic(t);
    t.setLesson(lesson);
    lessonRepository.save(lesson);
    return topicRepository.save(t);
  }

  @GetMapping("/api/topic/{tid}")
  public Topic findTopicById(@PathVariable("tid") int tid) {
    return topicRepository.findById(tid).get();
  }

  @PutMapping("/api/topic/{tid}")
  public Topic updateTopicById(@PathVariable("tid") int tid, @RequestBody Topic topic) {
    Topic t = topicRepository.findById(tid).get();
    t.setTitle(topic.getTitle());
    return topicRepository.save(t);
  }

  @DeleteMapping("/api/topic/{tid}")
  public void deleteTopic(@PathVariable("tid") int tid) {
    topicRepository.deleteById(tid);
  }
}
