package com.example.m2s11.services;

import com.example.m2s11.dtos.AnswerDTO;
import com.example.m2s11.mappers.AnswerMapper;
import com.example.m2s11.repositories.AnswerRepository;
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

    public List<AnswerDTO> findAll() {
        return answerMapper.map(answerRepository.findAll());
    }

    public AnswerDTO findById(Integer id) {
        return answerMapper.map(answerRepository.findById(id));
    }
}
