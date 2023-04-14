package com.example.m2s11.controllers;

import com.example.m2s11.dtos.QuizDTO;
import com.example.m2s11.models.Quiz;
import com.example.m2s11.services.QuizService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    public QuizDTO getById(@PathVariable("id") Long id) {
        return quizService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Quiz> create(@Valid @RequestBody QuizDTO quizDTO, UriComponentsBuilder uriComponentsBuilder) {
        Quiz quiz = quizService.create(quizDTO);
        URI uri = uriComponentsBuilder.path("/quizzes/{id}").buildAndExpand(quiz.getId()).toUri();

        return ResponseEntity.created(uri).body(quiz);
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody Quiz quiz) {
        quizService.update(quiz);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        quizService.delete(id);
    }

}
