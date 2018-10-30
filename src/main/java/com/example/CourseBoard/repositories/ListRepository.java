package com.example.CourseBoard.repositories;

import com.example.CourseBoard.models.ListWidget;

import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<ListWidget,Integer> {
}
