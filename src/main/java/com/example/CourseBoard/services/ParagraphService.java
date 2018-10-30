package com.example.CourseBoard.services;

import com.example.CourseBoard.models.ParagraphWidget;
import com.example.CourseBoard.models.Topic;
import com.example.CourseBoard.repositories.ParagraphRepository;
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

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ParagraphService {
  @Autowired
  ParagraphRepository paragraphRepository;
  @Autowired
  TopicRepository topicRepository;

  @GetMapping("api/paragraph/widget/{wid}")
  public ParagraphWidget findWidgetById(@PathVariable("wid") int wid) {
    return paragraphRepository.findById(wid).get();
  }

  @PostMapping("api/topic/{tid}/paragraph/widget")
  public ParagraphWidget createWidget(@PathVariable("tid") int tid, @RequestBody ParagraphWidget widget) {
    Topic topic = topicRepository.findById(tid).get();
    ParagraphWidget w = paragraphRepository.save(widget);
    topic.addWidget(w);
    w.setTopic(topic);
    topicRepository.save(topic);
    return  paragraphRepository.save(w);
  }

  @PutMapping("api/paragraph/widget/{wid}")
  public ParagraphWidget updateWidgetById(@PathVariable("wid") int wid, @RequestBody ParagraphWidget widget) {
    ParagraphWidget w = paragraphRepository.findById(wid).get();
    w.setParagraphWidget(widget);
    return paragraphRepository.save(w);
  }

  @DeleteMapping("api/paragraph/widget/{wid}")
  public void deleteWidgetById(@PathVariable("wid") int wid) {
    paragraphRepository.deleteById(wid);
  }
}
