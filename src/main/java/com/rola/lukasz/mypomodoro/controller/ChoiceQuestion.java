package com.rola.lukasz.mypomodoro.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ChoiceQuestion {
    private final String answer;
    private final String question;
    private final List<String> variants;
}
