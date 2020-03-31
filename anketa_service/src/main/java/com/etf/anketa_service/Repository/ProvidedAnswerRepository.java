package com.etf.anketa_service.Repository;

import com.etf.anketa_service.Model.ProvidedAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidedAnswerRepository extends JpaRepository<ProvidedAnswer, Long> {
}
