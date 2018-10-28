package com.example.CourseBoard.repositories;

import com.example.CourseBoard.models.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer>{
  @Query("SELECT person FROM Person person WHERE person.username=:username")
  public List<Person> findUserByUsername(@Param("username") String username);

  @Query("SELECT person FROM Person person WHERE person.username=:username AND person.password=:password")
  public List<Person> findUserByCredentials(@Param("username") String username, @Param("password") String password);
}

