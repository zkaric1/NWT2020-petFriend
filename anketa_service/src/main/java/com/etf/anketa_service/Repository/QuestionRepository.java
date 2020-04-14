package com.etf.anketa_service.Repository;

import com.etf.anketa_service.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findById(Long id);
}
