package com.rola.lukasz.mypomodoro.repository.sqlrepository;

import com.rola.lukasz.mypomodoro.model.Word;
import com.rola.lukasz.mypomodoro.repository.WordRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class JpaWordRepositoryTest {

    @Autowired
    private WordRepository jpWordRepository;


    @Test
    void addWord() {
        List<? extends Word> words = jpWordRepository.getWords();

        assertThat(words).hasSize(6);
        assertWordWork(words);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    private void assertWordWork(List<? extends Word> words) {
        Word firstWord = words.
                stream()
                .filter(word -> word.getForeignMeaning().equals("work"))
                .findFirst()
                .get();
        assertThat(firstWord.getForeignMeaning()).isEqualTo("work");
        assertThat(firstWord.getMotherMeaning()).isEqualTo("praca");
        assertThat(firstWord.getSynonymous()).containsExactlyInAnyOrder("job", "occupation");
    }
}