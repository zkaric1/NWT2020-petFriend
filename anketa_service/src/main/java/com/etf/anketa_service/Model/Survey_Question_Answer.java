package com.etf.anketa_service.Model;

import javax.persistence.*;

@Entity
@Table(name = "Anketa_Pitanje_Odgovor")
public class Survey_Question_Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "anketaPitanje", nullable = false)
    private Question_Survey pitanjeAnketa;

    @ManyToOne
    @JoinColumn(name = "ponudjeniOdgovor", nullable = false)
    private ProvidedAnswer ponudjeniOdgovor;

    @OneToOne
    @JoinColumn(name = "odgovorKorisnika")
    private User odgovorKorisnika;

    public Survey_Question_Answer() {
    }

    public Survey_Question_Answer(Question_Survey pitanjeAnketa, ProvidedAnswer ponudjeniOdgovor, User odgovorKorisnika) {
        this.pitanjeAnketa = pitanjeAnketa;
        this.ponudjeniOdgovor = ponudjeniOdgovor;
        this.odgovorKorisnika = odgovorKorisnika;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question_Survey getPitanjeAnketa() {
        return pitanjeAnketa;
    }

    public void setPitanjeAnketa(Question_Survey pitanjeAnketa) {
        this.pitanjeAnketa = pitanjeAnketa;
    }

    public ProvidedAnswer getPonudjeniOdgovor() {
        return ponudjeniOdgovor;
    }

    public void setPonudjeniOdgovor(ProvidedAnswer ponudjeniOdgovor) {
        this.ponudjeniOdgovor = ponudjeniOdgovor;
    }

    public User getOdgovorKorisnika() {
        return odgovorKorisnika;
    }

    public void setOdgovorKorisnika(User odgovorKorisnika) {
        this.odgovorKorisnika = odgovorKorisnika;
    }
}
