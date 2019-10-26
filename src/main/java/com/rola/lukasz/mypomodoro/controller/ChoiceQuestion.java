package com.rola.lukasz.mypomodoro.controller;

import com.rola.lukasz.mypomodoro.model.Word;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class ChoiceQuestion {
    private final String answer;
    private final String question;
    private final List<String> variants;

    public static ChoiceQuestion buildForeignLanguageChoiceQestion(Word word, List<Word> words) {
        return ChoiceQuestion.builder()
                .answer(word.getForeignMeaning())
                .question(word.getMotherMeaning())
                .variants(buildForeignLanguageChoiceVariants(words, word.getForeignMeaning()))
                .build();
    }

    public static ChoiceQuestion buildMotherLanguageChoiceQestion(Word word, List<Word> words) {
        return ChoiceQuestion.builder()
                .answer(word.getMotherMeaning())
                .question(word.getForeignMeaning())
                .variants(buildMotherLanguageChoiceVariants(words,word.getMotherMeaning()))
                .build();
    }

    private static List<String> buildMotherLanguageChoiceVariants(List<Word> words, String skipVariant) {
        List<String> variants = words.stream()
                .map(Word::getMotherMeaning)
                .filter(variant -> !variant.equals(skipVariant))
                .collect(Collectors.toList());

        Collections.shuffle(variants);

        return variants.stream()
                .limit(3)
                .collect(Collectors.toList());
    }

    private static List<String> buildForeignLanguageChoiceVariants(List<Word> choiceQuestions, String skipVariant) {
        List<String> variants = choiceQuestions.stream()
                .map(Word::getForeignMeaning)
                .filter(variant -> !variant.equals(skipVariant))
                .collect(Collectors.toList());

        Collections.shuffle(variants);

        return variants.stream()
                .limit(3)
                .collect(Collectors.toList());
    }
}
