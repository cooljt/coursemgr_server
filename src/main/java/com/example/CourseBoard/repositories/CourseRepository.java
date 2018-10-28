package com.example.CourseBoard.repositories;

import com.example.CourseBoard.models.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Integer>{}
