package com.example.m2s11.dtos;

import org.springframework.validation.FieldError;

public class ValidationErrorDTO {
    private final String field;
    private final String message;

    public ValidationErrorDTO(FieldError error) {
        this.field = error.getField();
        this.message = error.getDefaultMessage();
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
