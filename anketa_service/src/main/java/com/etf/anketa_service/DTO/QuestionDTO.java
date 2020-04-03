package com.etf.anketa_service.DTO;

import com.etf.anketa_service.Model.Question;
import com.etf.anketa_service.Model.Question_Survey;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class QuestionDTO {
    @NotNull
    private String questionText;

    @NotNull
    private boolean mandatory;

    private List<Long> questionSurveyEntries;

    public QuestionDTO() {}

    public QuestionDTO(String questionText, boolean mandatory, List<Long> questionSurveyEntries) {
        this.questionText = questionText;
        this.mandatory = mandatory;
        this.questionSurveyEntries = questionSurveyEntries;
    }

    public QuestionDTO(final Question question) {
        this.questionText = question.getQuestionText();
        this.mandatory = question.getMandatory();
        this.questionSurveyEntries = new ArrayList<>();
        for(final Question_Survey questionSurvey : question.getQuestionSurveyEntries()) {
            this.questionSurveyEntries.add(questionSurvey.getId());
        }
    }

    public Question toEntity() {
        Question question = new Question();
        question.setMandatory(this.mandatory);
        question.setQuestionText(this.questionText);
        return question;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public List<Long> getQuestionSurveyEntries() {
        return questionSurveyEntries;
    }

    public void setQuestionSurveyEntries(List<Long> questionSurveyEntries) {
        this.questionSurveyEntries = questionSurveyEntries;
    }
}
