package com.example.m2s11.controllers;

import com.example.m2s11.dtos.QuizDTO;
import com.example.m2s11.services.QuizService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public List<QuizDTO> getAll() {
        return quizService.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public QuizDTO getById(@PathParam("id") Integer id) {
        return quizService.findById(id);
    }
}
