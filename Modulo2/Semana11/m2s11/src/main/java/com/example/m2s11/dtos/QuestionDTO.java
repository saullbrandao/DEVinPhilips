package com.example.m2s11.dtos;

import com.example.m2s11.models.Quiz;
import lombok.Data;

@Data
public class QuestionDTO {
    private String title, text;
    private Quiz quiz;
}
