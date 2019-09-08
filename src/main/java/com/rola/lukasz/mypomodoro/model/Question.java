package com.rola.lukasz.mypomodoro.model;

import java.util.List;

public class Question {
    private String answer;
    private String question;
    private List<String> variants;

    public Question(String answer, String question, List<String> variants) {
        this.answer = answer;
        this.question = question;
        this.variants = variants;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getVariants() {
        return variants;
    }
}
