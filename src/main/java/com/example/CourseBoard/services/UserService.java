package com.example.CourseBoard.services;

import com.example.CourseBoard.models.Person;
import com.example.CourseBoard.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpSession;




@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserService {
  @Autowired
  PersonRepository personRepository;


  @PostMapping("api/register")
  public Person register(@RequestBody Person user, HttpSession session) {
    if (personRepository.findUserByUsername(user.getUsername()) != null) {
      session.setAttribute("currentPerson",user);
      return personRepository.save(user);
    }
    return null;
  }

  @GetMapping("api/profile")
  public Person profile(HttpSession session) {
    return (Person)session.getAttribute("currentPerson");
  }

  @PostMapping("api/login")
  public Person login(@RequestBody Person credentials, HttpSession session) {
    List<Person> persons = personRepository.findUserByCredentials(credentials.getUsername(),credentials.getPassword());
    if (persons.size() != 0) {
      session.setAttribute("currentPerson",persons.get(0));
      return persons.get(0);
    }
    return null;
  }

  @PostMapping("api/logout")
  public void logout(HttpSession session) {
    session.invalidate();
  }

  @GetMapping("api/users")
  public List<Person> getAllUsers(@RequestParam(name="username",required = false) String username) {
    if (username != null) {
      return personRepository.findUserByUsername(username);
    }
    return (List<Person>)personRepository.findAll();
  }

  @GetMapping("api/user/{userId}")
  public Person getUserById(@PathVariable("userId") int userId) {
    return personRepository.findById(userId).get();
  }

  @PutMapping("api/profile")
  public Person updateUserProfile(@RequestBody Person user, HttpSession session) {
    Person person = personRepository.findById(user.getId()).get();
    person.set(user);
    return personRepository.save(person);
  }

  @DeleteMapping("api/user/{userId}")
  public void deleteUser(@PathVariable("userId") int userId) {
    personRepository.deleteById(userId);
  }

}
