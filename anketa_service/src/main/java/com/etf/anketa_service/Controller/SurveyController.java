package com.etf.anketa_service.Controller;

import com.etf.anketa_service.Model.Survey;
import com.etf.anketa_service.Service.SurveyService;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/v1/survey")
@RestController
public class SurveyController {
    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    @GetMapping(path = "/getById")
    Survey getSurveyById(Long id) {
        return surveyService.getSurveyById(id);
    }

    @GetMapping(path = "/getByActiveStatus")
    List<Survey> getActiveSurveys(@RequestParam(name = "active", required = true) boolean active) {
        return surveyService.getByActiveStatus(active);
    }

    @DeleteMapping
    ResponseEntity<JSONObject> deleteAllSurveys() {
        return surveyService.deleteAll();
    }

    @PostMapping
    Survey addSurvey(@Valid @RequestBody Survey survey) {
        return surveyService.addSurvey(survey);
    }
}
