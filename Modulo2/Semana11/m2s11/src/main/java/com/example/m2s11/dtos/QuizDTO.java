package com.example.m2s11.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuizDTO {
    @NotBlank
    private String name, description;
}
