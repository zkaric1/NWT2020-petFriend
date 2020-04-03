package com.etf.anketa_service.Model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String questionText;

    @Column
    @NotNull
    private boolean mandatory;

    @OneToMany(mappedBy = "question")
    private List<Question_Survey> questionSurveyEntries;

    public Question() {
    }

    public Question(String questionText, boolean mandatory, List<Question_Survey> questionSurveyEntries) {
        this.questionText = questionText;
        this.mandatory = mandatory;
        this.questionSurveyEntries = questionSurveyEntries;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean getMandatory() {
        return this.mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public List<Question_Survey> getQuestionSurveyEntries() {
        return questionSurveyEntries;
    }

    public void setQuestionSurveyEntries(List<Question_Survey> questionSurveyEntries) {
        this.questionSurveyEntries = questionSurveyEntries;
    }
}
