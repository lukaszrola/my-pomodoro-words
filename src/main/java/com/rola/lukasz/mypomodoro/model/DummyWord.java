package com.rola.lukasz.mypomodoro.model;

import lombok.Builder;

import java.util.List;

@Builder
public class DummyWord implements Word {
    private final String motherMeaning;
    private final String foreignMeaning;
    private final List<String> synonymous;

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
