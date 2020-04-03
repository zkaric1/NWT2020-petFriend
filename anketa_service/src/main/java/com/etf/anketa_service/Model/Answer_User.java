package com.etf.anketa_service.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "answer_user")
public class Answer_User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "survey_question_answer")
    private Survey_Question_Answer surveyQuestionAnswer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Answer_User() {
    }

    public Answer_User(Survey_Question_Answer surveyQuestionAnswer, User user) {
        this.surveyQuestionAnswer = surveyQuestionAnswer;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Survey_Question_Answer getSurveyQuestionAnswer() {
        return surveyQuestionAnswer;
    }

    public void setSurveyQuestionAnswer(Survey_Question_Answer surveyQuestionAnswer) {
        this.surveyQuestionAnswer = surveyQuestionAnswer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
