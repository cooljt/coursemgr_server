package com.example.CourseBoard.repositories;

import com.example.CourseBoard.models.Lesson;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson,Integer>{
}
