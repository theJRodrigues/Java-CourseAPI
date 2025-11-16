package com.courses.controllers;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.DTOs.UpdateCourseDTO;
import com.courses.services.UpdateCourseByIdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@Validated
public class UpdateCourseByIdController {
    private final UpdateCourseByIdService service;

    @PutMapping("/{id}")
    @Tag(name = "Curso", description = "Cadastro e informações de cursos")
    @Operation(
            summary = "Atualiza curso pelo ID",
            description = "Responsável por atualizar as informações de name, category e teacher, sendo necessário passar todas as informações no body."
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Cursos encontrados",
                    content = @Content(schema = @Schema(implementation = ResponseCourseDTO.class))
            )
    )
    public ResponseEntity<ResponseCourseDTO> execute(@PathVariable UUID id, @Valid @RequestBody UpdateCourseDTO dto) {
        ResponseCourseDTO updated = service.updateById(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
}
