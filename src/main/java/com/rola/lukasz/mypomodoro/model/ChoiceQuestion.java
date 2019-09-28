package com.rola.lukasz.mypomodoro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ChoiceQuestion {
    private String answer;
    private String question;
    private List<String> variants;
}
