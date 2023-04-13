package com.example.m2s11.controllers;

import com.example.m2s11.dtos.QuizDTO;
import com.example.m2s11.models.Quiz;
import com.example.m2s11.services.QuizService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public QuizDTO getById(@PathVariable("id") Integer id) {
        return quizService.findById(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody QuizDTO quizDTO) {
        quizService.create(quizDTO);
    }

    @PutMapping
    public void update(@Valid @RequestBody Quiz quiz) {
        quizService.update(quiz);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        quizService.delete(id);
    }

}
