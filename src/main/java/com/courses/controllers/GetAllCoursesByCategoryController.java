package com.courses.controllers;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.services.GetAllCourseByCategoryService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class GetAllCoursesByCategoryController {
    private final GetAllCourseByCategoryService service;

    @GetMapping("/by-category")

    @Tag(name = "Curso", description = "Cadastro e informações de cursos")
    @Operation(
            summary = "Encontrar cursos pela categoria",
            description = "Encontra todos os cursos que contenham a categoria informada na query, sendo case insesitive"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Cursos encontrados",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseCourseDTO.class)))
            )
    )

    public ResponseEntity<List<ResponseCourseDTO>> execute(@RequestParam String category) {
        if (category.isBlank()) {
            throw new IllegalArgumentException("A categoria não pode ser vazia!");
        }
        List<ResponseCourseDTO> dto = service.getAllByCategory(category);

        return ResponseEntity.ok(dto);
    }
}
