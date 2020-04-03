package com.etf.anketa_service.DTO;

import com.etf.anketa_service.Model.ProvidedAnswer;
import com.etf.anketa_service.Model.Survey_Question_Answer;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ProvidedAnswerDTO {
    @NotNull
    private String answerText;

    private List<Long> surveyQuestionAnswerIds;

    public ProvidedAnswerDTO() {}

    public ProvidedAnswerDTO(String answerText, List<Long> surveyQuestionAnswerIds) {
        this.answerText = answerText;
        this.surveyQuestionAnswerIds = surveyQuestionAnswerIds;
    }

    public ProvidedAnswerDTO(final ProvidedAnswer providedAnswer) {
        this.answerText = providedAnswer.getAnswerText();
        this.surveyQuestionAnswerIds = new ArrayList<>();
        for(final Survey_Question_Answer questionAnswerSurvey : providedAnswer.getSurveyQuestionAnswers()) {
            this.surveyQuestionAnswerIds.add(questionAnswerSurvey.getId());
        }
    }

    public ProvidedAnswer toEntity() {
        ProvidedAnswer answer = new ProvidedAnswer();
        answer.setAnswerText(answerText);
        return answer;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public List<Long> getSurveyQuestionAnswerIds() {
        return surveyQuestionAnswerIds;
    }

    public void setSurveyQuestionAnswerIds(List<Long> surveyQuestionAnswerIds) {
        this.surveyQuestionAnswerIds = surveyQuestionAnswerIds;
    }
}
