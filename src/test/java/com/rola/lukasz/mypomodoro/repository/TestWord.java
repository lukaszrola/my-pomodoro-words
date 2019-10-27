package com.rola.lukasz.mypomodoro.repository;

import com.rola.lukasz.mypomodoro.model.Word;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
@AllArgsConstructor
public class TestWord implements Word {
    private final String motherMeaning;
    private final String foreignMeaning;
    private final List<String> synonymous;

    public TestWord(String foreignMeaning, String motherMeaning) {
        this.motherMeaning = motherMeaning;
        this.foreignMeaning = foreignMeaning;
        this.synonymous = List.of();
    }

    @Override
    public String getMotherMeaning() {
        return motherMeaning;
    }

    @Override
    public String getForeignMeaning() {
        return foreignMeaning;
    }

    @Override
    public List<String> getSynonymous() {
        return synonymous;
    }
}
