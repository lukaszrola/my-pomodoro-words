package com.rola.lukasz.mypomodoro.repository.sqlrepository;

import com.rola.lukasz.mypomodoro.model.Word;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "word")
@NoArgsConstructor
@AllArgsConstructor
public class JpaWord implements Word {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "word_generator")
    @SequenceGenerator(name="word_generator", sequenceName = "word_seq", allocationSize = 1)
    private Long id;

    private String motherMeaning;
    private String foreignMeaning;

    @Convert(converter = StringListConverter.class)
    List<String> synonymous;

    public Long getId() {
        return id;
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
