package com.courses.controllers;

import com.courses.DTOs.CreateCourseDTO;
import com.courses.DTOs.ResponseCourseDTO;
import com.courses.services.CreateCourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CreateCourseController {

  private final CreateCourseService service;

  @PostMapping
  public ResponseEntity<ResponseCourseDTO> execute(@Valid @RequestBody CreateCourseDTO dto) {
    ResponseCourseDTO responseDTO = service.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }
}
