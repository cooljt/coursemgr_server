package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Topic;
import com.example.CourseBoard.models.Widget;
import com.example.CourseBoard.repositories.TopicRepository;
import com.example.CourseBoard.repositories.WidgetRepository;

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
public class WidgetService {
  @Autowired
  WidgetRepository widgetRepository;
  @Autowired
  TopicRepository topicRepository;

  @GetMapping("api/topic/{tid}/widget")
  public List<Widget> findAllWidgets(@PathVariable("tid") int tid) {
    //return topicRepository.findById(tid).get().getWidgets();
    Topic topic = topicRepository.findById(tid).get();
    return widgetRepository.findWidgetOrderByRank(topic);
  }

  @PostMapping("api/topic/{tid}/widget")
  public Widget createWidget(@PathVariable("tid") int tid, @RequestBody Widget widget) {
    Topic topic = topicRepository.findById(tid).get();
    Widget w = widgetRepository.save(widget);
    topic.addWidget(w);
    w.setTopic(topic);
    topicRepository.save(topic);
    return widgetRepository.save(w);
  }

  @GetMapping("api/widget/{wid}")
  public Widget getWidgetById(@PathVariable("wid") int wid) {
    return widgetRepository.findById(wid).get();
  }

  @PutMapping("api/widget/{wid}")
  public Widget updateWidgetById(@PathVariable("wid") int wid, @RequestBody Widget widget) {
    Widget w = widgetRepository.findById(wid).get();
    w.setWidget(widget);
    return widgetRepository.save(w);
  }

  @DeleteMapping("api/widget/{wid}")
  public void deleteWidgetById(@PathVariable("wid") int wid) {
    widgetRepository.deleteById(wid);
  }

}
