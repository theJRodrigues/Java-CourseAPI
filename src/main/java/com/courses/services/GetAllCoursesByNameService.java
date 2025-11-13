package com.courses.services;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.domain.Course;
import com.courses.domain.CourseRepository;
import com.courses.exceptions.CourseNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllCoursesByNameService {
  private final CourseRepository repository;

  
  public List<ResponseCourseDTO> getAllByName(String name) {
    List<Course> courses = repository.findAllByNameContainingIgnoreCase(name);
    if (courses.isEmpty()) {
      throw new CourseNotFoundException("Não foram encontrados cursos com o nome: " + name);
    }

    return courses.stream().map(ResponseCourseDTO::fromEntity).toList();
  }
}
