package com.rola.lukasz.mypomodoro.controller;

import com.rola.lukasz.mypomodoro.model.Word;
import com.rola.lukasz.mypomodoro.repository.TestWord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WritingQuestionTest {

    private static final String MOTHER_MEANING = "motherMeaning";
    private static final String FOREIGN_MEANING = "foreignMeaning";
    private static final String SYNONYM_1 = "synonym1";
    private static final String SYNONYM_2 = "synonym2";

    @Test
    void writingQuestionTest() {
        Word word = TestWord.builder()
                .motherMeaning(MOTHER_MEANING)
                .foreignMeaning(FOREIGN_MEANING)
                .synonymous(List.of(SYNONYM_1, SYNONYM_2))
                .build();

        WritingQuestion writingQuestion = WritingQuestion.buildWritingQuestion(word);

        assertThat(writingQuestion.getQuestion()).isEqualTo(MOTHER_MEANING);
        assertThat(writingQuestion.getValidAnswers()).containsExactlyInAnyOrder(FOREIGN_MEANING, SYNONYM_1, SYNONYM_2);
    }
}