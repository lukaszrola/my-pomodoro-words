package com.rola.lukasz.mypomodoro.controller;

import com.rola.lukasz.mypomodoro.model.ChoiceQuestion;
import com.rola.lukasz.mypomodoro.service.WordsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@RestController
@AllArgsConstructor
public class WordsController {

    private final WordsService wordsService;

    @GetMapping("/categories")
    @CrossOrigin(origins = CorsConfiguration.ALL)
    public List<String> getCategories() {
        return List.of("english words", "german words");
    }

    @GetMapping("/motherLanguageChoiceQuestions")
    @CrossOrigin(origins = CorsConfiguration.ALL)
    public List<ChoiceQuestion> getMotherLanguageChoiceQuestions(@RequestParam Integer numberOfWords) {
     return wordsService.getMotherLanguageChoiceQuestions(numberOfWords);
    }

    @GetMapping("/foreignLanguageChoiceQuestions")
    @CrossOrigin(origins = CorsConfiguration.ALL)
    public List<ChoiceQuestion> getForeignLanguageChoiceQuestions(@RequestParam Integer numberOfWords) {
       return wordsService.getForeignLanguageChoiceQuestions(numberOfWords);
    }
}
