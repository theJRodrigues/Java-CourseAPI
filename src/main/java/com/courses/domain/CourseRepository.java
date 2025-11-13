package com.courses.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository {
  Course save(Course course);

  List<Course> findAll();

  Optional<Course> findById(UUID id);

  List<Course> findAllByNameContainingIgnoreCase(String name);

  List<Course> findAllByCategoryContainingIgnoreCase(String category);

  void deleteById(UUID id);

  boolean existsById(UUID id);
}
