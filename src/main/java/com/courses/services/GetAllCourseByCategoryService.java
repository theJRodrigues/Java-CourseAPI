package com.courses.services;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.domain.Course;
import com.courses.domain.CourseRepository;
import com.courses.exceptions.CourseNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class GetAllCourseByCategoryService {
  private final CourseRepository repository;

  public List<ResponseCourseDTO> getAllByCategory(String category) {
    List<Course> courses = repository.findAllByCategoryContainingIgnoreCase(category);
    if (courses.isEmpty()) {
      throw new CourseNotFoundException("Cursos não encontrados com a categoria: " + category);
    }

    return courses.stream().map(ResponseCourseDTO::fromEntity).toList();
  }
}
