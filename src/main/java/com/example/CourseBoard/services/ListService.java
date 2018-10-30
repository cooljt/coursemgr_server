package com.example.CourseBoard.services;

import com.example.CourseBoard.models.ListWidget;
import com.example.CourseBoard.models.Topic;
import com.example.CourseBoard.repositories.ListRepository;
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
public class ListService {
  @Autowired
  ListRepository listRepository;
  @Autowired
  TopicRepository topicRepository;

  @GetMapping("api/list/widget/{wid}")
  public ListWidget findWidgetById(@PathVariable("wid") int wid) {
    return listRepository.findById(wid).get();
  }

  @PostMapping("api/topic/{tid}/list/widget")
  public ListWidget createWidget(@PathVariable("tid") int tid, @RequestBody ListWidget widget) {
    Topic topic = topicRepository.findById(tid).get();
    ListWidget w = listRepository.save(widget);
    topic.addWidget(w);
    w.setTopic(topic);
    topicRepository.save(topic);
    return  listRepository.save(w);
  }

  @PutMapping("api/list/widget/{wid}")
  public ListWidget updateWidgetById(@PathVariable("wid") int wid, @RequestBody ListWidget widget) {
    ListWidget w = listRepository.findById(wid).get();
    w.setListWidget(widget);
    return listRepository.save(w);
  }

  @DeleteMapping("api/list/widget/{wid}")
  public void deleteWidgetById(@PathVariable("wid") int wid) {
    listRepository.deleteById(wid);
  }
}
