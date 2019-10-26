package com.rola.lukasz.mypomodoro.model;

import java.util.List;

public interface Word {
    String getMotherMeaning();
    String getForeignMeaning();
    List<String> getSynonymous();
}
