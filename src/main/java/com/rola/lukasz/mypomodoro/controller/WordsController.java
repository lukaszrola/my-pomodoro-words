package com.rola.lukasz.mypomodoro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordsController {

    @GetMapping("/categories")
    public List<String> getCategories(){
        return List.of("english words", "german words");
    }
}
