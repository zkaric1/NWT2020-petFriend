package com.etf.korisnik_service.model;

import javax.persistence.*;

@Entity
@Table(name = "korisnik_anketa")
public class KorisnikAnketa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Korisnik korisnik;
    @ManyToOne
    private Anketa anketa;

    public KorisnikAnketa() {}

    public KorisnikAnketa(Korisnik korisnik, Anketa anketa) {
        this.korisnik = korisnik;
        this.anketa = anketa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Anketa getAnketa() {
        return anketa;
    }

    public void setAnketa(Anketa anketa) {
        this.anketa = anketa;
    }

    @Override
    public String toString() {
        return "KorisnikAnketa{" +
                "id=" + id +
                ", korisnik=" + korisnik +
                ", anketa=" + anketa +
                '}';
    }
}
