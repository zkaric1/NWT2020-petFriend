package com.etf.anketa_service.Model;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Obavezno je unijeti opis ankete!")
    private String description;

    @Column
    @NotNull(message = "Obavezno je unijeti da li je anketa aktivna!")
    private boolean active;

    @OneToMany(mappedBy = "survey")
    private List<Question_Survey> questionSurveyEntries;

    public Survey() {
    }

    public Survey(String description, boolean active, List<Question_Survey> questionSurveyEntries) {
        this.description = description;
        this.active = active;
        this.questionSurveyEntries = questionSurveyEntries;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Question_Survey> getQuestionSurveyEntries() {
        return questionSurveyEntries;
    }

    public void setQuestionSurveyEntries(List<Question_Survey> questionSurveyEntries) {
        this.questionSurveyEntries = questionSurveyEntries;
    }
}
