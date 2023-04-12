package com.example.m2s11.controllers;

import com.example.m2s11.dtos.QuestionDTO;
import com.example.m2s11.services.QuestionService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<QuestionDTO> getAll() {
        return questionService.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public QuestionDTO getById(@PathParam("id") Integer id) {
        return questionService.findById(id);
    }
}
