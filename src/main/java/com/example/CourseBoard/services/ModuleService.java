package com.example.CourseBoard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseBoard.models.Module;
import com.example.CourseBoard.models.Course;
import com.example.CourseBoard.repositories.CourseRepository;
import com.example.CourseBoard.repositories.ModuleRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ModuleService {

  @Autowired
  CourseRepository courseRepository;
  @Autowired
  ModuleRepository moduleRepository;

  @GetMapping("/api/course/{cid}/module")
  public List<Module> getAllModules(@PathVariable("cid") int cid) {
    return courseRepository.findById(cid).get().getModules();
  }

  @PostMapping("/api/course/{cid}/module")
  public Module createModule(@PathVariable("cid") int cid, @RequestBody Module module) {
    Course course = courseRepository.findById(cid).get();
    Module m = moduleRepository.save(module);
    course.addModule(m);
    m.setCourse(course);
    courseRepository.save(course);
    return moduleRepository.save(m);
  }

  @GetMapping("/api/module/{mid}")
  public Module findModuleById(@PathVariable("mid") int mid) {
    return moduleRepository.findById(mid).get();
  }

  @PutMapping("/api/module/{mid}")
  public Module updateModuleById(@PathVariable("mid") int mid, @RequestBody Module m) {
    Module module = moduleRepository.findById(mid).get();
    module.setTitle(m.getTitle());
    return moduleRepository.save(module);
  }

  @DeleteMapping("/api/module/{mid}")
  public void deleteModuleById(@PathVariable("mid") int mid) {
    moduleRepository.deleteById(mid);
  }
}
