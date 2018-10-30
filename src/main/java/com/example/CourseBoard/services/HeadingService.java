package com.example.CourseBoard.services;

import com.example.CourseBoard.models.HeadingWidget;
import com.example.CourseBoard.models.Topic;
import com.example.CourseBoard.repositories.HeadingRepository;
import com.example.CourseBoard.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeadingService {
  @Autowired
  HeadingRepository headingRepository;
  @Autowired
  TopicRepository topicRepository;

  @GetMapping("api/heading/widget/{wid}")
  public HeadingWidget findWidgetById(@PathVariable("wid") int wid) {
    return headingRepository.findById(wid).get();
  }

  @PostMapping("api/topic/{tid}/heading/widget")
  public HeadingWidget createWidget(@PathVariable("tid") int tid, @RequestBody HeadingWidget widget) {
    Topic topic = topicRepository.findById(tid).get();
    HeadingWidget w = headingRepository.save(widget);
    topic.addWidget(w);
    w.setTopic(topic);
    topicRepository.save(topic);
    return  headingRepository.save(w);
  }

  @PutMapping("api/heading/widget/{wid}")
  public HeadingWidget updateWidgetById(@PathVariable("wid") int wid, @RequestBody HeadingWidget widget) {
    HeadingWidget w = headingRepository.findById(wid).get();
    w.setHeadingWidget(widget);
    return headingRepository.save(w);
  }

  @DeleteMapping("api/heading/widget/{wid}")
  public void deleteWidgetById(@PathVariable("wid") int wid) {
    headingRepository.deleteById(wid);
  }
}
