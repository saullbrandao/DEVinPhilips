package com.example.m2s11.services;

import com.example.m2s11.dtos.QuestionDTO;
import com.example.m2s11.mappers.QuestionMapper;
import com.example.m2s11.models.Question;
import com.example.m2s11.repositories.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public QuestionService(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }

    public List<QuestionDTO> findAll(Integer quizId) {
        if(quizId != null) {
            return findAllByQuizId(quizId);
        }
        return questionMapper.map(questionRepository.findAll());
    }

    public QuestionDTO findById(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return questionMapper.map(question);
    }

    private List<QuestionDTO> findAllByQuizId(Integer id) {
        return questionMapper.map(questionRepository.findAllByQuizId(id));
    }

    public Question create(QuestionDTO questionDTO) {
        Question question = questionMapper.map(questionDTO);
        return questionRepository.save(question);
    }

    public void update(Question updatedQuestion) {
        Question question = questionRepository.findById(updatedQuestion.getId()).orElseThrow(EntityNotFoundException::new);
        questionRepository.save(updatedQuestion);
    }

    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}
