package com.courses.DTOs;

import com.courses.domain.Course;
import jakarta.validation.constraints.NotBlank;

public record UpdateCourseDTO(
    @NotBlank(message = "O campo nome não pode estar vazio!") String name,
    @NotBlank(message = "O campo categoria não pode estar vazio!") String category,
    @NotBlank(message = "O campo professor não pode estar vazio!") String teacher) {
  public Course toEntity() {
    return Course.builder().name(name).category(category).teacher(teacher).build();
  }
}
