package com.courses.exceptions;

public class CourseNotPartialUpdatedException extends RuntimeException {
  public CourseNotPartialUpdatedException(String message) {
    super(message);
  }
}
