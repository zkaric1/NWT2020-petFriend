package com.etf.anketa_service.Repository;

import com.etf.anketa_service.Model.PossibleAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PossibleAnswerRepository extends JpaRepository<PossibleAnswer, Long> {
    List<PossibleAnswer> findAllByQuestion_SurveyId(Long surveyId);
    Optional<PossibleAnswer> findById(Long id);
}
