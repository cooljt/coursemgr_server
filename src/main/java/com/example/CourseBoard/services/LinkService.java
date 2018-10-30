package com.example.CourseBoard.services;

import com.example.CourseBoard.models.LinkWidget;
import com.example.CourseBoard.models.Topic;
import com.example.CourseBoard.repositories.LinkRepository;
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
@CrossOrigin(origins = "*", maxAge = 3600)
public class LinkService {
  @Autowired
  LinkRepository linkRepository;
  @Autowired
  TopicRepository topicRepository;

  @GetMapping("api/link/widget/{wid}")
  public LinkWidget findWidgetById(@PathVariable("wid") int wid) {
    return linkRepository.findById(wid).get();
  }

  @PostMapping("api/topic/{tid}/link/widget")
  public LinkWidget createWidget(@PathVariable("tid") int tid, @RequestBody LinkWidget widget) {
    Topic topic = topicRepository.findById(tid).get();
    LinkWidget w = linkRepository.save(widget);
    topic.addWidget(w);
    w.setTopic(topic);
    topicRepository.save(topic);
    return  linkRepository.save(w);
  }

  @PutMapping("api/link/widget/{wid}")
  public LinkWidget updateWidgetById(@PathVariable("wid") int wid, @RequestBody LinkWidget widget) {
    LinkWidget w = linkRepository.findById(wid).get();
    w.setLinkWidget(widget);
    return linkRepository.save(w);
  }

  @DeleteMapping("api/link/widget/{wid}")
  public void deleteWidgetById(@PathVariable("wid") int wid) {
    linkRepository.deleteById(wid);
  }
}
