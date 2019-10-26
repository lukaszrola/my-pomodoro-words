package com.rola.lukasz.mypomodoro.controller;

import com.rola.lukasz.mypomodoro.model.DummyWord;
import com.rola.lukasz.mypomodoro.model.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ChoiceQuestionTest {

    private List<Word> words;

    @BeforeEach
    void setUp(){
        words = List.of(
                buildWord("foreignMeaning1", "motherMeaning1"),
                buildWord("foreignMeaning2", "motherMeaning2"),
                buildWord("foreignMeaning3", "motherMeaning3"),
                buildWord("foreignMeaning4", "motherMeaning4"));
    }

    @Test
    void buildForeignLanguageChoiceQuestion() {
        Word firstWord = words.get(0);

        ChoiceQuestion choiceQuestion = ChoiceQuestion.buildForeignLanguageChoiceQestion(firstWord, words);

        assertThat(choiceQuestion.getAnswer()).isEqualTo(firstWord.getForeignMeaning());
        assertThat(choiceQuestion.getQuestion()).isEqualTo(firstWord.getMotherMeaning());
        assertThat(choiceQuestion.getVariants()).containsExactlyInAnyOrder("foreignMeaning2","foreignMeaning3","foreignMeaning4");
    }

    @Test
     void buildMotherLanguageChoiceQuestion() {
        Word firstWord = words.get(0);

        ChoiceQuestion choiceQuestion = ChoiceQuestion.buildMotherLanguageChoiceQestion(firstWord, words);

        assertThat(choiceQuestion.getAnswer()).isEqualTo(firstWord.getMotherMeaning());
        assertThat(choiceQuestion.getQuestion()).isEqualTo(firstWord.getForeignMeaning());
        assertThat(choiceQuestion.getVariants()).containsExactlyInAnyOrder("motherMeaning2","motherMeaning3","motherMeaning4");
    }

    private DummyWord buildWord(String foreignMeaning, String motherMeaning) {
        return DummyWord.builder()
                .foreignMeaning(foreignMeaning)
                .motherMeaning(motherMeaning)
                .build();
    }
}