package com.example.m2s11.controllers;

import com.example.m2s11.dtos.QuestionDTO;
import com.example.m2s11.models.Question;
import com.example.m2s11.services.QuestionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{id}")
    public QuestionDTO getById(@PathVariable("id") Long id) {
        return questionService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Question> create(@Valid @RequestBody QuestionDTO questionDTO, UriComponentsBuilder uriComponentsBuilder) {
        Question question = questionService.create(questionDTO);
        URI uri = uriComponentsBuilder.path("/questions/{id}").buildAndExpand(question.getId()).toUri();

        return ResponseEntity.created(uri).body(question);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Question question) {
        questionService.update(question);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        questionService.delete(id);
    }
}
