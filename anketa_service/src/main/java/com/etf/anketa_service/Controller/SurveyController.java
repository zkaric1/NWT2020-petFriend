package com.etf.anketa_service.Controller;

import com.etf.anketa_service.Repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/v1/survey")
@RestController
public class SurveyController {
    @Autowired
    private SurveyRepository surveyRepository;
}
