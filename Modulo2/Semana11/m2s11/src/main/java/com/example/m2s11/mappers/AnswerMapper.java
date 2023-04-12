package com.example.m2s11.mappers;

import com.example.m2s11.dtos.AnswerDTO;
import com.example.m2s11.models.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    Answer map(AnswerDTO source);

    AnswerDTO map(Answer source);

    List<AnswerDTO> map(List<Answer> source);
}
