package com.example.m2s11.mappers;

import com.example.m2s11.dtos.QuizDTO;
import com.example.m2s11.models.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuizMapper {
    Quiz map(QuizDTO source);

    QuizDTO map(Quiz source);

    List<QuizDTO> map(List<Quiz> source);
}
