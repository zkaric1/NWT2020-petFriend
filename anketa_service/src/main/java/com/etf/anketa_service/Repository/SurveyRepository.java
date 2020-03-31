package com.etf.anketa_service.Repository;

import com.etf.anketa_service.Model.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

}
