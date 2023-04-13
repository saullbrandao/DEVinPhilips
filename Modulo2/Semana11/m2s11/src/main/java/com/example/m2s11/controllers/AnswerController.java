package com.example.m2s11.controllers;

import com.example.m2s11.dtos.AnswerDTO;
import com.example.m2s11.services.AnswerService;
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

    @GetMapping
    @RequestMapping("/{id}")
    public AnswerDTO getById(@PathVariable("id") Integer id) {
        return answerService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody AnswerDTO answerDTO) {
        answerService.create(answerDTO);
    }
}
