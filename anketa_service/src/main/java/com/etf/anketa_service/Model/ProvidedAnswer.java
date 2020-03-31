package com.etf.anketa_service.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "PonudjeniOdgovor")
public class ProvidedAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "Tekst odgovora je obavezan!")
    private String tekstOdgovora;

    @OneToMany(mappedBy = "ponudjeniOdgovor")
    private List<Survey_Question_Answer> surveyQuestionAnswers;

    public ProvidedAnswer() {}

    public ProvidedAnswer(String tekstOdgovora, List<Survey_Question_Answer> surveyQuestionAnswers) {
        this.tekstOdgovora = tekstOdgovora;
        this.surveyQuestionAnswers = surveyQuestionAnswers;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTekstOdgovora() {
        return tekstOdgovora;
    }
    public void setTekstOdgovora(String tekstOdgovora) {
        this.tekstOdgovora = tekstOdgovora;
    }

    public List<Survey_Question_Answer> getSurveyQuestionAnswers() {
        return surveyQuestionAnswers;
    }
    public void setSurveyQuestionAnswers(List<Survey_Question_Answer> surveyQuestionAnswers) {
        this.surveyQuestionAnswers = surveyQuestionAnswers;
    }
}
