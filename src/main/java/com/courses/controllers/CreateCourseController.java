package com.courses.controllers;

import com.courses.DTOs.CreateCourseDTO;
import com.courses.DTOs.ResponseCourseDTO;
import com.courses.services.CreateCourseService;
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
    @Tag(name = "Curso", description = "Cadastro e informações de cursos")
    @Operation(
            summary = "Criar curso",
            description = "Responsável por criar curso através de name, category e teacher"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "Curso criado com sucesso",
                    content = {
                            @Content(schema = @Schema(
                                    implementation = ResponseCourseDTO.class
                            ))
                    }
            )

    })
    public ResponseEntity<ResponseCourseDTO> execute(@Valid @RequestBody CreateCourseDTO dto) {
        ResponseCourseDTO responseDTO = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
