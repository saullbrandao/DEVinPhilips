package com.example.m2s11.controllers;

import com.example.m2s11.dtos.AnswerDTO;
import com.example.m2s11.models.Answer;
import com.example.m2s11.services.AnswerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public List<AnswerDTO> getAll(@RequestParam(required = false, name = "question") Integer questionId) {
        return answerService.findAll(questionId);
    }

    @GetMapping("/{id}")
    public AnswerDTO getById(@PathVariable("id") Long id) {
        return answerService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Answer> create(@Valid @RequestBody AnswerDTO answerDTO, UriComponentsBuilder uriComponentsBuilder) {
        Answer answer = answerService.create(answerDTO);
        URI uri = uriComponentsBuilder.path("/answers/{id}").buildAndExpand(answer.getId()).toUri();
        return ResponseEntity.created(uri).body(answer);

    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Answer answer) {
        answerService.update(answer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        answerService.delete(id);
    }
}
