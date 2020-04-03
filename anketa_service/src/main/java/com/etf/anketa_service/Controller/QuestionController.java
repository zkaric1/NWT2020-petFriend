package com.etf.anketa_service.Controller;

import com.etf.anketa_service.DTO.QuestionDTO;
import com.etf.anketa_service.Exception.QuestionException;
import com.etf.anketa_service.Model.Question;
import com.etf.anketa_service.Service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "/v1/question")
@RestController
public class QuestionController {
    private QuestionService questionService;

    public QuestionController(final QuestionService questionService) {
        this.questionService = questionService;
    }

    // GET mappings
    @GetMapping("/all")
    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = questionService.fetchAllQuestions();
        List<QuestionDTO> required_questions = new ArrayList<>();
        for(final Question question : questions) {
            required_questions.add(new QuestionDTO(question));
        }
        return required_questions;
    }

    @GetMapping
    public QuestionDTO getQuestion(@PathVariable Long questionId) {
        return new QuestionDTO(questionService.fetchQuestion(questionId));
    }
}
