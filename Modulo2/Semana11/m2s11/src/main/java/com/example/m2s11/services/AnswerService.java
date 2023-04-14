package com.example.m2s11.services;

import com.example.m2s11.dtos.AnswerDTO;
import com.example.m2s11.mappers.AnswerMapper;
import com.example.m2s11.models.Answer;
import com.example.m2s11.repositories.AnswerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    public AnswerService(AnswerRepository answerRepository, AnswerMapper answerMapper) {
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
    }

    public List<AnswerDTO> findAll(Integer questionId) {
        if(questionId != null) {
            return findAllByQuestionId(questionId);
        }

        return answerMapper.map(answerRepository.findAll());
    }

    public AnswerDTO findById(Long id) {
        Answer answer = answerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return answerMapper.map(answer);
    }

    private List<AnswerDTO> findAllByQuestionId(Integer questionId) {
        return answerMapper.map(answerRepository.findAllByQuestionId(questionId));
    }

    public Answer create(AnswerDTO answerDTO) {
        Answer answer = answerMapper.map(answerDTO);
        return answerRepository.save(answer);
    }

    public void update(Answer updatedAnswer) {
        Answer answer = answerRepository.findById(updatedAnswer.getId()).orElseThrow(EntityNotFoundException::new);
        answerRepository.save(updatedAnswer);
    }

    public void delete(Long id) {
        answerRepository.deleteById(id);
    }
}
