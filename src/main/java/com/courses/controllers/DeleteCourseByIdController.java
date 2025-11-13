package com.courses.controllers;

import com.courses.services.DeleteCourseByIdService;
import jakarta.validation.constraints.Pattern;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/course")
@RestController
@RequiredArgsConstructor
@Validated
public class DeleteCourseByIdController {
  private final DeleteCourseByIdService service;

  @DeleteMapping("/{id}")
  public ResponseEntity<String> execute(
      @PathVariable
          @Pattern(
              regexp =
                  "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$",
              message = "Formato de UUID inválido!")
          String id) {
    service.deleteById(UUID.fromString(id));
    return ResponseEntity.ok("Curso excluído com sucesso!");
  }
}
