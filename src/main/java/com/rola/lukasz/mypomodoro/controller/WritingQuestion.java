package com.rola.lukasz.mypomodoro.controller;

import com.google.common.collect.ImmutableList;
import com.rola.lukasz.mypomodoro.model.Word;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class WritingQuestion {
    private final String question;
    private final List<String> validAnswers;

    public static WritingQuestion buildWritingQuestion(Word word) {
        return WritingQuestion
                .builder()
                .question(word.getMotherMeaning())
                .validAnswers(buildValidAnswers(word))
                .build();
    }

    private static List<String> buildValidAnswers(Word word) {
        return ImmutableList.<String>builder()
                .add(word.getForeignMeaning())
                .addAll(word.getSynonymous())
                .build();
    }
}
