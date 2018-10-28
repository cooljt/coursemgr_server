package com.example.CourseBoard.repositories;

import com.example.CourseBoard.models.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer>{
}
