package com.etf.anketa_service.Repository;

import com.etf.anketa_service.Model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findAll();
    void deleteById(Long id);
    void deleteAll();
    Optional<Question> findById(Long id);
}
