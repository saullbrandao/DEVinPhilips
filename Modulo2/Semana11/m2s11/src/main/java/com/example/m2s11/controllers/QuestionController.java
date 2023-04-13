package com.example.m2s11.controllers;

import com.example.m2s11.dtos.QuestionDTO;
import com.example.m2s11.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<QuestionDTO> getAll(@RequestParam(required = false, name = "quiz") Integer quizId) {
        return questionService.findAll(quizId);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public QuestionDTO getById(@PathVariable("id") Integer id) {
        return questionService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody QuestionDTO questionDTO) {
        questionService.create(questionDTO);
    }
}
