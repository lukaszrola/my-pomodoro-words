package com.rola.lukasz.mypomodoro.controller;

import com.google.gson.Gson;
import com.rola.lukasz.mypomodoro.model.ChoiceQuestion;
import com.rola.lukasz.mypomodoro.service.WordsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WordsController.class)
public class WordsControllerTest {

    private static final String MOTHER_LANGUAGE_CHOICE_QUESTIONS_URL = "/motherLanguageChoiceQuestions?numberOfWords=2";
    private static final String FOREIGN_LANGUAGE_CHOICE_QUESTIONS_URL = "/foreignLanguageChoiceQuestions?numberOfWords=2";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private WordsService wordsService;

    @Test
    void getMotherLanguageChoiceQuestions() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(MOTHER_LANGUAGE_CHOICE_QUESTIONS_URL)
                .accept(MediaType.APPLICATION_JSON);
        List<ChoiceQuestion> expectedResponse = motherLanguageChoiceResponse();
        when(wordsService.getMotherLanguageChoiceQuestions(2))
                .thenReturn(expectedResponse);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(new Gson().toJson(expectedResponse)));
    }

    @Test
    void getForeignLanguageChoiceQuestions() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(FOREIGN_LANGUAGE_CHOICE_QUESTIONS_URL)
                .accept(MediaType.APPLICATION_JSON);
        List<ChoiceQuestion> expectedResponse = foreignLanguageChoiceResponse();
        when(wordsService.getForeignLanguageChoiceQuestions(2))
                .thenReturn(expectedResponse);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(new Gson().toJson(expectedResponse)));
    }


    private List<ChoiceQuestion> motherLanguageChoiceResponse() {
        return List.of(
                ChoiceQuestion.builder()
                        .answer("pies")
                        .question("dog")
                        .variants(List.of("pies", "koń", "krowa"))
                        .build(),
                ChoiceQuestion.builder()
                        .answer("jabłko")
                        .question("apple")
                        .variants(List.of("koza", "jabłko", "wiśnia", "drzewo"))
                        .build());
    }

    private List<ChoiceQuestion> foreignLanguageChoiceResponse() {
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