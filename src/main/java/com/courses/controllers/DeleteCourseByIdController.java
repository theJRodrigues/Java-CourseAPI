package com.courses.controllers;

import com.courses.services.DeleteCourseByIdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/course")
@RestController
@RequiredArgsConstructor
@Validated
public class DeleteCourseByIdController {
    private final DeleteCourseByIdService service;

    @DeleteMapping("/{id}")
    @Tag(name = "Curso", description = "Cadastro e informações de cursos")
    @Operation(
            summary = "Deletar curso",
            description = "Deleta um curso através de um ID no formato UUI enviado pela URL"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Curso deletado com sucesso!",
                    content = {
                            @Content(schema = @Schema(implementation = String.class))
                    }
            )
    })
    public ResponseEntity<String> execute(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.ok("Curso excluído com sucesso!");
    }
}
