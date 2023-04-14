package com.example.m2s11.services;

import com.example.m2s11.dtos.QuizDTO;
import com.example.m2s11.mappers.QuizMapper;
import com.example.m2s11.models.Quiz;
import com.example.m2s11.repositories.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public QuizDTO findById(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return quizMapper.map(quiz);
    }

    public Quiz create(QuizDTO quizDTO) {
        Quiz quiz = quizMapper.map(quizDTO);
        return quizRepository.save(quiz);
    }

    public void update(Quiz updatedQuiz) {
        Quiz quiz = quizRepository.findById(updatedQuiz.getId()).orElseThrow(EntityNotFoundException::new);
        quizRepository.save(updatedQuiz);
    }

    public void delete(Long id) {
        quizRepository.deleteById(id);
    }
}
