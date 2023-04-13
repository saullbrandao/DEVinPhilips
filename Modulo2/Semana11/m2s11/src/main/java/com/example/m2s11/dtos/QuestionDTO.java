package com.example.m2s11.dtos;

import com.example.m2s11.models.Quiz;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class QuestionDTO {
    @NotBlank
    private String title, text;
    private Quiz quiz;
}
