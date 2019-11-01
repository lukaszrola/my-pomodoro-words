package com.rola.lukasz.mypomodoro.repository.sqlrepository;

import com.rola.lukasz.mypomodoro.repository.WordRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface JpaWordRepository extends CrudRepository<JpaWord,Long>, WordRepository {
    @Override
    default List<JpaWord> getWords() {
        return findAll();
    }

    List<JpaWord> findAll();
}
