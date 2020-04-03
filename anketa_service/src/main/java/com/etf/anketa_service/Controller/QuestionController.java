package com.etf.anketa_service.Controller;

import com.etf.anketa_service.DTO.QuestionDTO;
import com.etf.anketa_service.Model.Question;
import com.etf.anketa_service.Service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger URL: localhost:8081/api/swagger-ui.html
 * */
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
    public QuestionDTO getQuestion(@RequestParam("id") Long questionId) throws Exception {
        return new QuestionDTO(questionService.fetchQuestion(questionId));
    }

    // DELETE mappings
    @DeleteMapping("/all")
    public void deleteAllQuestions() {
        questionService.deleteAllQuestions();
    }

    @DeleteMapping("/deleteById")
    public void deleteQuestionById(@RequestParam("id") Long questionId) throws Exception {
        questionService.deleteQuestionById(questionId);
    }

    // POST mappings
    @PostMapping
    public QuestionDTO addQuestion(@RequestBody QuestionDTO newQuestion) {
        questionService.addQuestion(newQuestion.toEntity());
        return newQuestion;
    }

    // PUT mappings
    @PutMapping
    public QuestionDTO editQuestion(@RequestParam("id") Long questionId, @RequestBody QuestionDTO newQuestion) throws Exception {
        questionService.editQuestion(questionId, newQuestion.toEntity());
        return newQuestion;
    }
}
