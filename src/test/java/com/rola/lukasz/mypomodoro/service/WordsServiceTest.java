package com.rola.lukasz.mypomodoro.service;

import com.rola.lukasz.mypomodoro.controller.ChoiceQuestion;
import com.rola.lukasz.mypomodoro.controller.WritingQuestion;
import com.rola.lukasz.mypomodoro.model.DummyWord;
import com.rola.lukasz.mypomodoro.model.Word;
import com.rola.lukasz.mypomodoro.repository.WordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class WordsServiceTest {
    private static final String MOTHER_MEANING = "motherMeaning";
    private static final String FOREIGN_MEANING = "foreignMeaning";

    @Mock
    private WordRepository wordRepository;
    @InjectMocks
    private WordsService wordsService;

    @BeforeEach
    void setUp() {
        List<Word> words = List.of(
                buildWord("foreignMeaning1", "motherMeaning1"),
                buildWord("foreignMeaning2", "motherMeaning2"),
                buildWord("foreignMeaning3", "motherMeaning3"),
                buildWord("foreignMeaning4", "motherMeaning4"));

        lenient().when(wordRepository.getWords()).thenReturn(words);
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

    private DummyWord buildWord(String foreignMeaning, String motherMeaning) {
        return DummyWord.builder()
                .foreignMeaning(foreignMeaning)
                .motherMeaning(motherMeaning)
                .synonymous(List.of())
                .build();
    }
}