package com.example.m2s11.services;

import com.example.m2s11.dtos.QuestionDTO;
import com.example.m2s11.mappers.QuestionMapper;
import com.example.m2s11.models.Question;
import com.example.m2s11.repositories.QuestionRepository;
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

    public QuestionDTO findById(Integer id) {
        return questionMapper.map(questionRepository.findById(id));
    }

    private List<QuestionDTO> findAllByQuizId(Integer id) {
        return questionMapper.map(questionRepository.findAllByQuizId(id));
    }

    public void create(QuestionDTO questionDTO) {
        System.out.println(questionDTO);
        Question question = questionMapper.map(questionDTO);
        System.out.println(question);

        questionRepository.save(question);
    }
}
