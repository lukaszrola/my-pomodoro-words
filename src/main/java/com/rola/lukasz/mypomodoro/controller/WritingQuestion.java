package com.rola.lukasz.mypomodoro.controller;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class WritingQuestion {
    private final String question;
    private final List<String> validAnswers;
}
