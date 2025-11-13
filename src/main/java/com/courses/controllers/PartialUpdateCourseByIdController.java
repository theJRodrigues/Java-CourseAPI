package com.courses.controllers;

import com.courses.DTOs.PatchCourseDTO;
import com.courses.DTOs.ResponseCourseDTO;
import com.courses.services.PartialUpdateCourseByIdService;
import jakarta.validation.constraints.Pattern;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class PartialUpdateCourseByIdController {
  private final PartialUpdateCourseByIdService service;

  @PatchMapping("/{id}")
  public ResponseEntity<ResponseCourseDTO> execute(
      @PathVariable
          @Pattern(
              regexp =
                  "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$",
              message = "Formato de UUID inválido!")
          String id,
      @RequestBody PatchCourseDTO dto) {
    ResponseCourseDTO responseDTO = service.partialUpdate(UUID.fromString(id), dto);
    return ResponseEntity.ok(responseDTO);

  }
}
