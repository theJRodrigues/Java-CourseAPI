package com.courses.controllers;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.DTOs.UpdateCourseDTO;
import com.courses.services.UpdateCourseByIdService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@Validated
public class UpdateCourseByIdController {
  private final UpdateCourseByIdService service;

  @PutMapping("/{id}")
  public ResponseEntity<ResponseCourseDTO> execute(
      @PathVariable
          @Pattern(
              regexp =
                  "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$",
              message = "Formato de UUID inválido!")
          String id,
      @Valid @RequestBody UpdateCourseDTO dto) {

      ResponseCourseDTO updated = service.updateById(UUID.fromString(id), dto);

      return ResponseEntity.status(HttpStatus.OK).body(updated);
  }
}
