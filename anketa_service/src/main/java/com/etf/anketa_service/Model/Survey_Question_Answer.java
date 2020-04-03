package com.etf.anketa_service.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "survey_question_answer")
public class Survey_Question_Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "survey_question", nullable = false)
    private Question_Survey questionSurvey;

    @ManyToOne
    @JoinColumn(name = "provided_answer", nullable = false)
    private ProvidedAnswer providedAnswer;

    @OneToOne(mappedBy = "surveyQuestionAnswer")
    private Answer_User answerUser;

    public Survey_Question_Answer() {
    }

    public Survey_Question_Answer(Question_Survey questionSurvey, ProvidedAnswer providedAnswer, Answer_User answerUser) {
        this.questionSurvey = questionSurvey;
        this.providedAnswer = providedAnswer;
        this.answerUser = answerUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question_Survey getQuestionSurvey() {
        return questionSurvey;
    }

    public void setQuestionSurvey(Question_Survey questionSurvey) {
        this.questionSurvey = questionSurvey;
    }

    public ProvidedAnswer getProvidedAnswer() {
        return providedAnswer;
    }

    public void setProvidedAnswer(ProvidedAnswer providedAnswer) {
        this.providedAnswer = providedAnswer;
    }

    public Answer_User getAnswerUser() {
        return answerUser;
    }

    public void setAnswerUser(Answer_User answerUser) {
        this.answerUser = answerUser;
    }
}
