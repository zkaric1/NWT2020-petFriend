package com.etf.anketa_service.Service;

import com.etf.anketa_service.Model.Question;
import com.etf.anketa_service.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(final QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> fetchAllQuestions() {
        return questionRepository.findAll();
    }

    public Question fetchQuestion(Long questionId) {
        return questionRepository.getById(questionId);
    }
}
