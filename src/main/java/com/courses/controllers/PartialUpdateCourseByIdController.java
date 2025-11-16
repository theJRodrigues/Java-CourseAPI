package com.courses.controllers;

import com.courses.DTOs.PartialUpdateCourseDTO;
import com.courses.DTOs.ResponseCourseDTO;
import com.courses.services.PartialUpdateCourseByIdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class PartialUpdateCourseByIdController {
    private final PartialUpdateCourseByIdService service;

    @PatchMapping("/{id}")
    @Tag(name = "Curso", description = "Cadastro e informações de cursos")
    @Operation(
            summary = "Atualiza curso pelo ID",
            description = "Responsável por atualizar as informações de name, category, teacher e active, onde os 3 atributos são opcionais."
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Cursos encontrados",
                    content = @Content(schema = @Schema(implementation = ResponseCourseDTO.class))
            )
    )
    public ResponseEntity<ResponseCourseDTO> execute(@PathVariable UUID id, @RequestBody PartialUpdateCourseDTO dto) {
        ResponseCourseDTO responseDTO = service.partialUpdate(id, dto);
        return ResponseEntity.ok(responseDTO);

    }
}
