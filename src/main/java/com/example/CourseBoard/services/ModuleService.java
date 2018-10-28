package com.example.CourseBoard.services;

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

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ModuleService {
  @GetMapping("/api/course/{cid}/module")
  public List<Module> getAllModules(@PathVariable("cid") int cid) {
    for (Course course:CourseService.courses) {
      if (course.getId() == cid) {
        return course.getModules();
      }
    }
    return new ArrayList<>();
  }

  @PostMapping("/api/course/{cid}/module")
  public List<Module> createModule(@PathVariable("cid") long cid, @RequestBody Module module) {
    for (Course course:CourseService.courses) {
      if (course.getId() == cid) {
        course.getModules().add(module);
        return course.getModules();
      }
    }
    return new ArrayList<>();
  }

  @GetMapping("/api/module/{mid}")
  public Module findModuleById(@PathVariable("mid") long mid) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        if (module.getId() == mid) {
          return module;
        }
      }
    }
    return new Module();
  }

  @PutMapping("/api/module/{mid}")
  public List<Module> updateModuleById(@PathVariable("mid") long mid, @RequestBody Module m) {
    for (Course course:CourseService.courses) {
      List<Module> temp = course.getModules();
      for (int i = 0; i < temp.size(); i++) {
        if (temp.get(i).getId() == mid) {
          temp.set(i,m);
          return course.getModules();
        }
      }
    }
    return new ArrayList<>();
  }

  @DeleteMapping("/api/module/{mid}")
  public List<Module> deleteModuleById(@PathVariable("mid") long mid) {
    for (Course course:CourseService.courses) {
      for (Module module:course.getModules()) {
        if (module.getId() == mid) {
          course.getModules().remove(module);
          return course.getModules();
        }
      }
    }
    return new ArrayList<>();
  }
}
