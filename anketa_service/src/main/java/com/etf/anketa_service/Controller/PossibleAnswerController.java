package com.etf.anketa_service.Controller;

import com.etf.anketa_service.Model.PossibleAnswer;
import com.etf.anketa_service.Service.PossibleAnswerService;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/v1/possibleAnswer")
@RestController
public class PossibleAnswerController {
    private PossibleAnswerService possibleAnswerService;

    public PossibleAnswerController(final PossibleAnswerService possibleAnswerService) {
        this.possibleAnswerService = possibleAnswerService;
    }

    @GetMapping(path = "/getAll")
    List<PossibleAnswer> getAllPossibleAnswers() {
        return possibleAnswerService.findAll();
    }

    @GetMapping(path = "getAllBySurveyId")
    List<PossibleAnswer> getAllPossibleAnswersForSurvey(@RequestParam(name = "surveyId", required = true) Long surveyId) {
        return possibleAnswerService.getAllForSurvey(surveyId);
    }

    @GetMapping(path = "/getById")
    PossibleAnswer getById(@RequestParam(name = "id", required = true) Long id) {
        return possibleAnswerService.getPossibleAnswerById(id);
    }

    @DeleteMapping(path = "deleteAll")
    ResponseEntity<JSONObject> deleteAllPossibleAnswers() {
        return possibleAnswerService.deleteAllPossibleAnswers();
    }

    @DeleteMapping(path = "/deleteById")
    ResponseEntity<JSONObject> deleteSpecifiedPossibleAnswer(@RequestParam(name = "id", required = true) Long id) {
        return possibleAnswerService.deleteSpecifiedPossibleAnswer(id);
    }

    @PostMapping
    PossibleAnswer addPossibleAnswer(@Valid @RequestBody PossibleAnswer possibleAnswer) {
        return possibleAnswerService.addPossibleAnswer(possibleAnswer);
    }

    @PutMapping
    PossibleAnswer editPossibleAnswer(@Valid @RequestBody PossibleAnswer newPossibleAnswer, @RequestParam(name = "id", required = true) Long possibleAnswerId) {
        return possibleAnswerService.putPossibleAnswer(newPossibleAnswer, possibleAnswerId);
    }
}
