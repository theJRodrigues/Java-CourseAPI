package com.courses.DTOs;

import com.courses.domain.Course;
import java.time.LocalDateTime;
import java.util.UUID;

public record ResponseCourseDTO(
    UUID id,
    String name,
    String category,
    String teacher,
    Boolean active,
    LocalDateTime created_at,
    LocalDateTime updated_at) {
  public static ResponseCourseDTO fromEntity(Course course) {
    return new ResponseCourseDTO(
        course.getId(),
        course.getName(),
        course.getCategory(),
        course.getTeacher(),
        course.isActive(),
        course.getCreated_at(),
        course.getUpdated_at());
  }
}
