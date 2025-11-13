package com.courses.services;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.DTOs.UpdateCourseDTO;
import com.courses.domain.Course;
import com.courses.domain.CourseRepository;
import com.courses.exceptions.CourseNotFoundException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCourseByIdService {
  private final CourseRepository repository;

  public ResponseCourseDTO updateById(UUID id, UpdateCourseDTO dto) {
    Course course =
        repository
            .findById(id)
            .orElseThrow(() -> new CourseNotFoundException("Curso não encontrado com o id: " + id));

    course.setName(dto.name());
    course.setCategory(dto.category());
    course.setTeacher(dto.teacher());

    Course updated = repository.save(course);

    return ResponseCourseDTO.fromEntity(updated);
  }
}
