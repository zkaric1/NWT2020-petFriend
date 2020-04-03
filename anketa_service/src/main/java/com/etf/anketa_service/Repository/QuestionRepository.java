package com.etf.anketa_service.Repository;

import com.etf.anketa_service.Model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    public List<Question> findAll();
    public Question getById(Long id);
}
