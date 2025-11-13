package com.courses.services;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.domain.CourseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCourseService {
  private final CourseRepository repository;

  public List<ResponseCourseDTO> getAll() {
    return repository.findAll().stream()
        .map(
            c ->
                new ResponseCourseDTO(
                    c.getId(),
                    c.getName(),
                    c.getCategory(),
                    c.getTeacher(),
                    c.isActive(),
                    c.getCreated_at(),
                    c.getUpdated_at()))
        .toList();
  }
}
