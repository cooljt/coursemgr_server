package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Person;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserService {
  List<Person> users = new ArrayList<>();
  Random random = new Random();
  @PostMapping("api/register")
  public Person register(@RequestBody Person user, HttpSession session) {
    for (Person usr:users) {
      if (usr.getUsername().equals(user.getUsername())) {
        return null;
      }
    }
    session.setAttribute("currentPerson", user);
    user.setId(random.nextInt(Integer.MAX_VALUE));
    users.add(user);
    return user;
  }

  @GetMapping("api/profile")
  public Person profile(HttpSession session) {
    Person currentPerson = (Person)session.getAttribute("currentPerson");
    return currentPerson;
  }

  @PostMapping("api/login")
  public Person login(@RequestBody Person credentials, HttpSession session) {
    for (Person usr:users) {
      if (usr.getUsername().equals(credentials.getUsername())
              && usr.getPassword().equals(credentials.getPassword())) {
        session.setAttribute("currentPerson", usr);
        return usr;
      }
    }
    return new Person();
  }

  @PostMapping("api/logout")
  public void logout(HttpSession session) {
    session.invalidate();
  }

  @GetMapping("api/users")
  public List<Person> getAllUsers() {
    return users;
  }

  @GetMapping("api/user/{userId}")
  public Person getUserById(@PathVariable("userId") int userId) {
    return users.stream().filter(user -> user.getId() == userId).findFirst().get();
  }

}