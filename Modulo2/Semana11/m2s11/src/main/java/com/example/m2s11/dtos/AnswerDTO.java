package com.example.m2s11.dtos;

import com.example.m2s11.models.Question;
import lombok.Data;

@Data
public class AnswerDTO {
    private String text;
    private Question question;
}
