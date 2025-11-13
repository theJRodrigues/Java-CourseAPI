package com.courses.DTOs;

import com.courses.exceptions.CourseNotPatchedException;

public record PatchCourseDTO(String name, String category, String teacher, Boolean active) {
  public void validate() {
    if (name != null && name.isBlank()) {
      throw new CourseNotPatchedException("O valor de name não pode ser nulo ou vazio!");
    }
    if (category != null && category.isBlank()) {
      throw new CourseNotPatchedException("O valor de category não pode ser nulo ou vazio!");
    }
    if (teacher != null && teacher.isBlank()) {
      throw new CourseNotPatchedException("O valor de teacher não pode ser nulo ou vazio!");
    }
  }
}
