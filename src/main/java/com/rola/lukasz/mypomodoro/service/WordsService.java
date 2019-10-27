package com.rola.lukasz.mypomodoro.service;

import com.rola.lukasz.mypomodoro.controller.ChoiceQuestion;
import com.rola.lukasz.mypomodoro.controller.WritingQuestion;
import com.rola.lukasz.mypomodoro.model.Word;
import com.rola.lukasz.mypomodoro.repository.WordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WordsService {
    private final WordRepository wordRepository;

    public List<ChoiceQuestion> getMotherLanguageChoiceQuestions(Integer numberOfWords) {
        if (numberOfWordsIsInvalid(numberOfWords))
            return List.of();

        List<Word> words = new ArrayList<>(wordRepository.getWords());
        Collections.shuffle(words);

        return words
                .stream()
                .map(word -> ChoiceQuestion.buildMotherLanguageChoiceQestion(word, words))
                .limit(numberOfWords)
                .collect(Collectors.toList());
    }

    public List<ChoiceQuestion> getForeignLanguageChoiceQuestions(Integer numberOfWords) {
        if (numberOfWordsIsInvalid(numberOfWords))
            return List.of();

        List<Word> words = new ArrayList<>(wordRepository.getWords());
        Collections.shuffle(words);

        return words
                .stream()
                .map(word -> ChoiceQuestion.buildForeignLanguageChoiceQestion(word, words))
                .limit(numberOfWords)
                .collect(Collectors.toList());
    }

    public List<WritingQuestion> getWritingQuestions(Integer numberOfWords) {
        if (numberOfWordsIsInvalid(numberOfWords))
            return List.of();

        List<Word> words = new ArrayList<>(wordRepository.getWords());
        Collections.shuffle(words);

        return words
                .stream()
                .map(WritingQuestion::buildWritingQuestion)
                .limit(numberOfWords)
                .collect(Collectors.toList());
    }

    private boolean numberOfWordsIsInvalid(Integer numberOfWords) {
        return numberOfWords <= 0;
    }
}
