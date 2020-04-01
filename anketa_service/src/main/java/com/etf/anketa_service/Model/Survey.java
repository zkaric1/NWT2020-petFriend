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
@Table(name = "Anketa")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Obavezno je unijeti opis ankete!")
    private String opis;

    @Column
    @NotNull(message = "Obavezno je unijeti da li je anketa aktivna!")
    private boolean aktivna;

    @OneToMany(mappedBy = "anketa")
    private List<Question_Survey> questionSurveyEntries;

    public Survey() {
    }

    public Survey(String opis, boolean aktivna, List<Question_Survey> questionSurveyEntries) {
        this.opis = opis;
        this.aktivna = aktivna;
        this.questionSurveyEntries = questionSurveyEntries;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpis() {
        return this.opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean getAktivna() {
        return this.aktivna;
    }

    public void setAktivna(boolean aktivna) {
        this.aktivna = aktivna;
    }

    public List<Question_Survey> getQuestionSurveyEntries() {
        return questionSurveyEntries;
    }

    public void setQuestionSurveyEntries(List<Question_Survey> questionSurveyEntries) {
        this.questionSurveyEntries = questionSurveyEntries;
    }
}
