package com.example.CourseBoard.services;

import com.example.CourseBoard.models.ImageWidget;
import com.example.CourseBoard.models.Topic;
import com.example.CourseBoard.repositories.ImageRepository;
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
public class ImageService {
  @Autowired
  ImageRepository imageRepository;
  @Autowired
  TopicRepository topicRepository;

  @GetMapping("api/image/widget/{wid}")
  public ImageWidget findWidgetById(@PathVariable("wid") int wid) {
    return imageRepository.findById(wid).get();
  }

  @PostMapping("api/topic/{tid}/image/widget")
  public ImageWidget createWidget(@PathVariable("tid") int tid, @RequestBody ImageWidget widget) {
    Topic topic = topicRepository.findById(tid).get();
    ImageWidget w = imageRepository.save(widget);
    topic.addWidget(w);
    w.setTopic(topic);
    topicRepository.save(topic);
    return  imageRepository.save(w);
  }

  @PutMapping("api/image/widget/{wid}")
  public ImageWidget updateWidgetById(@PathVariable("wid") int wid, @RequestBody ImageWidget widget) {
    ImageWidget w = imageRepository.findById(wid).get();
    w.setImageWidget(widget);
    return imageRepository.save(w);
  }

  @DeleteMapping("api/image/widget/{wid}")
  public void deleteWidgetById(@PathVariable("wid") int wid) {
    imageRepository.deleteById(wid);
  }
}
