package com.example.CourseBoard.repositories;

import com.example.CourseBoard.models.Person;
import com.example.CourseBoard.models.Topic;
import com.example.CourseBoard.models.Widget;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer>{
  @Query("SELECT widget FROM Widget widget WHERE widget.topic=:topic ORDER BY widget.rank")
  public List<Widget> findWidgetOrderByRank(@Param("topic") Topic topic);
}
