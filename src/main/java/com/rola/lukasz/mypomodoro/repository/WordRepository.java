package com.rola.lukasz.mypomodoro.repository;

import com.rola.lukasz.mypomodoro.model.Word;

import java.util.List;

public interface WordRepository {
    List<? extends Word> getWords();
}
