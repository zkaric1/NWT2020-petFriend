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
@Table(name = "Pitanje_Anketa")
public class Question_Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pitanjeId", nullable = false)
    private Question pitanje;

    @ManyToOne
    @JoinColumn(name = "anketaId", nullable = false)
    private Survey anketa;

    @OneToMany(mappedBy = "pitanjeAnketa")
    private List<Survey_Question_Answer> surveyQuestionAnswers;

    public Question_Survey() {}

    public Question_Survey(Question pitanje, Survey anketa, List<Survey_Question_Answer> surveyQuestionAnswers) {
        this.pitanje = pitanje;
        this.anketa = anketa;
        this.surveyQuestionAnswers = surveyQuestionAnswers;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Question getPitanje() {
        return pitanje;
    }
    public void setPitanje(Question pitanje) {
        this.pitanje = pitanje;
    }

    public Survey getAnketa() {
        return anketa;
    }
    public void setAnketa(Survey anketa) {
        this.anketa = anketa;
    }

    public List<Survey_Question_Answer> getSurveyQuestionAnswers() {
        return surveyQuestionAnswers;
    }
    public void setSurveyQuestionAnswers(List<Survey_Question_Answer> surveyQuestionAnswers) {
        this.surveyQuestionAnswers = surveyQuestionAnswers;
    }
}
