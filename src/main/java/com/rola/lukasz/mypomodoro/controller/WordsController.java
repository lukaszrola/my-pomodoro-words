package com.rola.lukasz.mypomodoro.controller;

import com.rola.lukasz.mypomodoro.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordsController {

    @GetMapping("/categories")
    public List<String> getCategories() {
        return List.of("english words", "german words");
    }

    @GetMapping("/questions")
    public List<Question> getQuestions(@RequestParam Integer numberOfWords, @RequestParam String category) {
        return List.of(
                new Question("dog", "pies", List.of("mouse", "cat", "bird")),
                new Question("apple", "jablko", List.of("cherry", "pineaple", "blueberry"))
        );

    }
}
