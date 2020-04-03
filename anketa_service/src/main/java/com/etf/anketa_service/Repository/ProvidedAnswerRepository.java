package com.etf.anketa_service.Repository;

import com.etf.anketa_service.Model.ProvidedAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProvidedAnswerRepository extends JpaRepository<ProvidedAnswer, Long> {
    List<ProvidedAnswer> findAll();
    void deleteById(Long id);
    void deleteAll();
    Optional<ProvidedAnswer> findById(Long id);
}
