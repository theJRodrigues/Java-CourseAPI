package com.courses.controllers;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.services.GetAllCourseByCategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class GetAllCoursesByCategoryController {
  private final GetAllCourseByCategoryService service;

  @GetMapping("/by-category")
  public ResponseEntity<List<ResponseCourseDTO>> execute(@RequestParam String category) {
    if (category.isBlank()) {
      throw new IllegalArgumentException("A categoria não pode ser vazia!");
    }
    List<ResponseCourseDTO> dto = service.getAllByCategory(category);

    return ResponseEntity.ok(dto);
  }
}
