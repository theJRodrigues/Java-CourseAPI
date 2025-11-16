package com.courses.controllers;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.services.GetCourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class GetCoursesController {
    private final GetCourseService service;

    @GetMapping
    @Tag(name = "Curso", description = "Cadastro e informações de cursos")
    @Operation(
            summary = "Encontrar cursos",
            description = "Encontra todos os cursos cadastrados"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Cursos encontrados",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseCourseDTO.class)))
            )
    )
    public ResponseEntity<List<ResponseCourseDTO>> execute() {
        return ResponseEntity.ok(service.getAll());
    }
}
