package com.courses.services;

import com.courses.DTOs.PartialUpdateCourseDTO;
import com.courses.DTOs.ResponseCourseDTO;
import com.courses.domain.Course;
import com.courses.domain.CourseRepository;
import com.courses.exceptions.CourseNotPartialUpdatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PartialUpdateCourseByIdService {
    private final CourseRepository repository;

    public ResponseCourseDTO partialUpdate(UUID id, PartialUpdateCourseDTO dto) {
        dto.validate();
        Course course =
                repository
                        .findById(id)
                        .orElseThrow(() -> new CourseNotPartialUpdatedException("Curso não encontrado com id: " + id));

        Optional.ofNullable(dto.name()).ifPresent(course::setName);
        Optional.ofNullable(dto.category()).ifPresent(course::setCategory);
        Optional.ofNullable(dto.teacher()).ifPresent(course::setTeacher);
        Optional.ofNullable(dto.active()).ifPresent(course::setActive);

        Course updated = repository.save(course);
        return ResponseCourseDTO.fromEntity(updated);
    }
}
