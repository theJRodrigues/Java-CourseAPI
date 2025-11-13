package com.courses.exceptions;

public class CourseNotPatchedException extends RuntimeException {
  public CourseNotPatchedException(String message) {
    super(message);
  }
}
