package com.etf.anketa_service.Repository;

import com.etf.anketa_service.Model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> getAllByActiveEquals(boolean active);
}
