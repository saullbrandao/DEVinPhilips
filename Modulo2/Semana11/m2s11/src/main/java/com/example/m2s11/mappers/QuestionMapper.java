package com.example.m2s11.mappers;

import com.example.m2s11.dtos.QuestionDTO;
import com.example.m2s11.models.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
    Question map(QuestionDTO source);

    QuestionDTO map(Question source);

    List<QuestionDTO> map(List<Question> source);
}
