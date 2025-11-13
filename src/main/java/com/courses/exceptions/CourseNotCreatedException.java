package com.courses.exceptions;

public class CourseNotCreatedException extends RuntimeException {
  public CourseNotCreatedException(String message) {
    super(message);
  }
}
