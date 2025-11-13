package com.courses.services;

import com.courses.DTOs.CreateCourseDTO;
import com.courses.DTOs.ResponseCourseDTO;
import com.courses.domain.Course;
import com.courses.domain.CourseRepository;
import com.courses.exceptions.CourseNotCreatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCourseService {
  private final CourseRepository repository;

  public ResponseCourseDTO create(CreateCourseDTO dto) {
    try {
      Course created = repository.save(dto.toEntity());
      return ResponseCourseDTO.fromEntity(created);
    } catch (DataIntegrityViolationException ex) {
      throw new CourseNotCreatedException(
          "Erro interno ao tentar criar o curso! \n" + ex.getMessage());
    }
  }
}
