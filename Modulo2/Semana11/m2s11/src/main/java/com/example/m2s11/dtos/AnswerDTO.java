package com.example.m2s11.dtos;

import com.example.m2s11.models.Question;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AnswerDTO {
    @NotBlank
    private String text;
    private Question question;
}
