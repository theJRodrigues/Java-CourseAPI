package com.courses.services;

import com.courses.domain.CourseRepository;
import com.courses.exceptions.CourseNotFoundException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCourseByIdService {
  private final CourseRepository repository;

  public void deleteById(UUID id) {
    if (!repository.existsById(id)) {
      throw new CourseNotFoundException("Não foi encontrado nenhum cadastro com esse ID!");
    }
    repository.deleteById(id);
  }
}
