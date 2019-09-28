package com.rola.lukasz.mypomodoro.service;

import com.rola.lukasz.mypomodoro.model.ChoiceQuestion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsService {
    public List<ChoiceQuestion> getMotherLanguageChoiceQuestions(Integer numberOfWords) {
        return List.of(
                ChoiceQuestion.builder()
                        .answer("pies")
                        .question("dog")
                        .variants(List.of("kot", "koń", "krowa"))
                        .build(),
                ChoiceQuestion.builder()
                        .answer("jabłko")
                        .question("apple")
                        .variants(List.of("koza","wiśnia", "drzewo"))
                        .build());
    }

    public List<ChoiceQuestion> getForeignLanguageChoiceQuestions(Integer numberOfWords) {
        return List.of(
                ChoiceQuestion.builder()
                        .answer("dog")
                        .question("pies")
                        .variants(List.of("mouse", "cat", "bird"))
                        .build(),
                ChoiceQuestion.builder()
                        .answer("apple")
                        .question("jabłko")
                        .variants(List.of("cherry", "pineaple", "blueberry"))
                        .build());
    }
}
