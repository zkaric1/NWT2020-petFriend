package com.etf.anketa_service.Controller;

import com.etf.anketa_service.Model.Survey;
import com.etf.anketa_service.Service.SurveyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping
    Survey addSurvey(@Valid @RequestBody Survey survey) {
        return surveyService.addSurvey(survey);
    }
}
