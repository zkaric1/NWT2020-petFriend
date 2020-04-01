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
@Table(name = "Pitanje")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String tekstPitanja;

    @Column
    @NotNull
    private boolean obavezno;

    @OneToMany(mappedBy = "pitanje")
    private List<Question_Survey> questionSurveyEntries;

    public Question() {
    }

    public Question(String tekst, boolean obavezno, List<Question_Survey> questionSurveyEntries) {
        this.tekstPitanja = tekst;
        this.obavezno = obavezno;
        this.questionSurveyEntries = questionSurveyEntries;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTekstPitanja() {
        return this.tekstPitanja;
    }

    public void setTekstPitanja(String tekst) {
        this.tekstPitanja = tekst;
    }

    public boolean getObavezno() {
        return this.obavezno;
    }

    public void setObavezno(boolean obavezno) {
        this.obavezno = obavezno;
    }

    public List<Question_Survey> getQuestionSurveyEntries() {
        return questionSurveyEntries;
    }

    public void setQuestionSurveyEntries(List<Question_Survey> questionSurveyEntries) {
        this.questionSurveyEntries = questionSurveyEntries;
    }
}
