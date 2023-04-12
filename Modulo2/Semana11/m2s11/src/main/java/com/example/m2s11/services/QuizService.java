package com.example.m2s11.services;

import com.example.m2s11.dtos.QuizDTO;
import com.example.m2s11.mappers.QuizMapper;
import com.example.m2s11.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository quizRepository, QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
    }

    public List<QuizDTO> findAll() {
        return quizMapper.map(quizRepository.findAll());
    }

    public QuizDTO findById(Integer id) {
        return quizMapper.map(quizRepository.findById(id));
    }
}
