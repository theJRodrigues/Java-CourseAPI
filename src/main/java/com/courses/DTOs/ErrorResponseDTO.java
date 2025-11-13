package com.courses.DTOs;

public record ErrorResponseDTO(int status, String error, Object details) {}
