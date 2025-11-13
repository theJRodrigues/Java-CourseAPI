package com.courses.controllers;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.services.GetAllCoursesByNameService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class GetAllCoursesByNameController {
  private final GetAllCoursesByNameService service;

  @GetMapping("/by-name")
  public ResponseEntity<List<ResponseCourseDTO>> execute(@RequestParam String name) {
    if (name.isBlank()) {
      throw new IllegalArgumentException("O nome não pode ser vazio");
    }

    List<ResponseCourseDTO> dto = service.getAllByName(name);

    return ResponseEntity.ok(dto);
  }
}
