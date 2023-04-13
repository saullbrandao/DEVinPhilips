package com.example.m2s11.controllers;

import com.example.m2s11.dtos.AnswerDTO;
import com.example.m2s11.models.Answer;
import com.example.m2s11.services.AnswerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public AnswerDTO getById(@PathVariable("id") Integer id) {
        return answerService.findById(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody AnswerDTO answerDTO) {
        answerService.create(answerDTO);
    }

    @PutMapping
    public void update(@RequestBody Answer answer) {
        answerService.update(answer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        answerService.delete(id);
    }
}
