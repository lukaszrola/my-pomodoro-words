package com.rola.lukasz.mypomodoro.service;

import com.rola.lukasz.mypomodoro.controller.ChoiceQuestion;
import com.rola.lukasz.mypomodoro.controller.WritingQuestion;
import com.rola.lukasz.mypomodoro.repository.TestWord;
import com.rola.lukasz.mypomodoro.repository.WordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WordsServiceTest {
    private static final String MOTHER_MEANING = "motherMeaning";
    private static final String FOREIGN_MEANING = "foreignMeaning";

    private WordRepository wordRepository;
    private WordsService wordsService;

    @BeforeEach
    void setUp() {
        wordRepository = () -> List.of(
                 new TestWord("foreignMeaning1", "motherMeaning1"),
                 new TestWord("foreignMeaning2", "motherMeaning2"),
                 new TestWord("foreignMeaning3", "motherMeaning3"),
                 new TestWord("foreignMeaning4", "motherMeaning4"));

        wordsService = new WordsService(wordRepository);
    }

    @Test
    void foreignLanguageChoiceQuestionsTest() {
        List<ChoiceQuestion> foreignLanguageChoiceQuestions = wordsService.getForeignLanguageChoiceQuestions(2);

        assertThat(foreignLanguageChoiceQuestions).hasSize(2);
        assertThat(foreignLanguageChoiceQuestions.get(0).getQuestion()).contains(MOTHER_MEANING);
        assertThat(foreignLanguageChoiceQuestions.get(0).getAnswer()).contains(FOREIGN_MEANING);
    }

    @Test
    void motherLanguageChoiceQuestionsTest() {
        List<ChoiceQuestion> foreignLanguageChoiceQuestions = wordsService.getMotherLanguageChoiceQuestions(2);

        assertThat(foreignLanguageChoiceQuestions).hasSize(2);
        assertThat(foreignLanguageChoiceQuestions.get(0).getQuestion()).contains(FOREIGN_MEANING);
        assertThat(foreignLanguageChoiceQuestions.get(0).getAnswer()).contains(MOTHER_MEANING);
    }

    @Test
    void writingQuestionTest() {
        List<WritingQuestion> writingQuestions = wordsService.getWritingQuestions(2);

        assertThat(writingQuestions).hasSize(2);
        assertThat(writingQuestions.get(0).getQuestion()).contains(MOTHER_MEANING);
    }

    @Test
    void foreignLanguageInvalidNumberOfWords() {
        List<ChoiceQuestion> foreignLanguageChoiceQuestions = wordsService.getForeignLanguageChoiceQuestions(-1);

        assertThat(foreignLanguageChoiceQuestions).isEmpty();
    }

    @Test
    void motherLanguageInvalidNumberOfWords() {
        List<ChoiceQuestion> foreignLanguageChoiceQuestions = wordsService.getMotherLanguageChoiceQuestions(-1);

        assertThat(foreignLanguageChoiceQuestions).isEmpty();
    }

    @Test
    void writingQuestionInvalidNumberOfWords() {
        List<WritingQuestion> writingQuestions = wordsService.getWritingQuestions(-1);

        assertThat(writingQuestions).isEmpty();
    }
}