package com.courses.controllers;

import com.courses.DTOs.ResponseCourseDTO;
import com.courses.services.GetAllCoursesByNameService;
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
public class GetAllCoursesByNameController {
    private final GetAllCoursesByNameService service;

    @GetMapping("/by-name")
    @Tag(name = "Curso", description = "Cadastro e informações de cursos")
    @Operation(
            summary = "Encontrar cursos pelo nome",
            description = "Encontra todos os cursos que contenham o nome informado na query, sendo case insesitive"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Cursos encontrados",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseCourseDTO.class)))
            )
    )

    public ResponseEntity<List<ResponseCourseDTO>> execute(@RequestParam String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio");
        }

        List<ResponseCourseDTO> dto = service.getAllByName(name);

        return ResponseEntity.ok(dto);
    }
}
