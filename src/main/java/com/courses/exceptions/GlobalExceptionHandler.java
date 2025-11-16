package com.courses.exceptions;

import com.courses.DTOs.ErrorResponseDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCourseNotFound(CourseNotFoundException ex) {
        ErrorResponseDTO responseDTO =
                new ErrorResponseDTO(HttpStatus.NOT_FOUND.value(), "Not found", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    @ExceptionHandler(CourseNotCreatedException.class)
    public ResponseEntity<ErrorResponseDTO> handleCourseNotCreated(CourseNotCreatedException ex) {
        ErrorResponseDTO responseDTO =
                new ErrorResponseDTO(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(), "Created error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationDTOErrors(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));

        ErrorResponseDTO responseDTO =
                new ErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), "Invalid Parameters", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationParamErrors(
            ConstraintViolationException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(v -> errors.put("Message: ", v.getMessage()));

        ErrorResponseDTO responseDTO =
                new ErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), "Invalid Parameters", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
    }

    @ExceptionHandler(CourseNotPartialUpdatedException.class)
    public ResponseEntity<ErrorResponseDTO> handleCourseNotPatched(CourseNotPartialUpdatedException ex) {
        ErrorResponseDTO responseDTO =
                new ErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), "Patch error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
    }
}
