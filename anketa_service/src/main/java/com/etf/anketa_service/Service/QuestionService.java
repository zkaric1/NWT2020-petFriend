package com.etf.anketa_service.Service;

import com.etf.anketa_service.Exception.QuestionException;
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
        Question question = (questionRepository.findById(questionId).isPresent()) ? questionRepository.findById(questionId).get() : null;
        if(question == null) {
            throw new QuestionException();
        }
        return question;
    }

    public void deleteAllQuestions() {
        questionRepository.deleteAll();
    }

    public void deleteQuestionById(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    public void addQuestion(final Question question) {
        questionRepository.save(question);
    }

    public void editQuestion(Long id, Question question) {
        Question toEdit = (questionRepository.findById(id).isPresent()) ? questionRepository.findById(id).get() : null;
        if(toEdit == null) {
            throw new QuestionException();
        }
        else {
            toEdit.setQuestionText(question.getQuestionText());
            toEdit.setMandatory(question.getMandatory());
            toEdit.setQuestionSurveyEntries(question.getQuestionSurveyEntries());
            questionRepository.save(question);
        }
    }
}
