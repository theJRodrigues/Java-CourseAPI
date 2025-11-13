package com.courses.controllers;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.services.GetCourseService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class GetCoursesController {
  private final GetCourseService service;

  @GetMapping
  public ResponseEntity<List<ResponseCourseDTO>> execute() {
    return ResponseEntity.ok(service.getAll());
  }
}
