package com.rola.lukasz.mypomodoro.repository.sqlrepository;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Converter
class StringListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return String.join(";", attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData)
                .map(this::convertToList)
                .orElse(List.of());
    }

    private List<String> convertToList(String dbData) {
        return Arrays.asList(dbData.split(";"));
    }
}
