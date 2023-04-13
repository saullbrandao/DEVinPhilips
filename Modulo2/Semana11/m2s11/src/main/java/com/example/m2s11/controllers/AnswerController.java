package com.example.m2s11.controllers;

import com.example.m2s11.dtos.AnswerDTO;
import com.example.m2s11.services.AnswerService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public AnswerDTO getById(@PathParam("id") Integer id) {
        return answerService.findById(id);
    }
}
