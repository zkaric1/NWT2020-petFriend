package com.etf.anketa_service.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "provided_answer")
public class ProvidedAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "Tekst odgovora je obavezan!")
    private String answerText;

    @OneToMany(mappedBy = "providedAnswer")
    private List<Survey_Question_Answer> surveyQuestionAnswers;

    public ProvidedAnswer() {
    }

    public ProvidedAnswer(String answerText, List<Survey_Question_Answer> surveyQuestionAnswers) {
        this.answerText = answerText;
        this.surveyQuestionAnswers = surveyQuestionAnswers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public List<Survey_Question_Answer> getSurveyQuestionAnswers() {
        return surveyQuestionAnswers;
    }

    public void setSurveyQuestionAnswers(List<Survey_Question_Answer> surveyQuestionAnswers) {
        this.surveyQuestionAnswers = surveyQuestionAnswers;
    }
}
