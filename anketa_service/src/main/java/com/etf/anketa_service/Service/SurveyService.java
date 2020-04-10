package com.etf.anketa_service.Service;

import com.etf.anketa_service.Exception.SurveyException;
import com.etf.anketa_service.Model.Survey;
import com.etf.anketa_service.Repository.SurveyRepository;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    private SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey addSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Survey getSurveyById(Long id) {
        return surveyRepository.findById(id).orElseThrow(() -> new SurveyException(id));
    }

    public List<Survey> getByActiveStatus(boolean active) {
        return surveyRepository.getAllByActiveEquals(active);
    }

    public ResponseEntity<JSONObject> deleteAll() {
        surveyRepository.deleteAll();
        JSONObject returnValue = new JSONObject();
        returnValue.put("message", "Uspjesno obrisane ankete!");
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
}
