package com.rola.lukasz.mypomodoro.repository.dummywordrepository;

import com.rola.lukasz.mypomodoro.repository.WordRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class DummyWordRepository implements WordRepository {
    @Override
    public List<DummyWord> getWords() {

        return List.of(
                DummyWord
                        .builder()
                        .foreignMeaning("apple")
                        .motherMeaning("jabłko")
                        .synonymous(List.of())
                        .build(),
                DummyWord
                        .builder()
                        .foreignMeaning("horse")
                        .motherMeaning("koń")
                        .synonymous(List.of())
                        .build(),
                DummyWord
                        .builder()
                        .foreignMeaning("dog")
                        .motherMeaning("pies")
                        .synonymous(List.of())
                        .build(),
                DummyWord
                        .builder()
                        .foreignMeaning("guinea pig")
                        .motherMeaning("świnka morska")
                        .synonymous(List.of())
                        .build(),
                DummyWord
                        .builder()
                        .foreignMeaning("job")
                        .motherMeaning("praca")
                        .synonymous(List.of("work","occupation"))
                        .build(),
                DummyWord
                        .builder()
                        .foreignMeaning("shoemaker")
                        .motherMeaning("szewc")
                        .synonymous(List.of("cobbler"))
                        .build()
        );
    }
}
