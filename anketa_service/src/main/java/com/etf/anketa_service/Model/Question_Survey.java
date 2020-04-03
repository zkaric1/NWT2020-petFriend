package com.etf.anketa_service.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "question_survey")
public class Question_Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    @OneToMany(mappedBy = "questionSurvey")
    private List<Survey_Question_Answer> surveyQuestionAnswers;

    public Question_Survey() {
    }

    public Question_Survey(Question question, Survey survey, List<Survey_Question_Answer> surveyQuestionAnswers) {
        this.question = question;
        this.survey = survey;
        this.surveyQuestionAnswers = surveyQuestionAnswers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<Survey_Question_Answer> getSurveyQuestionAnswers() {
        return surveyQuestionAnswers;
    }

    public void setSurveyQuestionAnswers(List<Survey_Question_Answer> surveyQuestionAnswers) {
        this.surveyQuestionAnswers = surveyQuestionAnswers;
    }
}
