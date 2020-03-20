package com.etf.anketa_service.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pitanje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String tekstPitanja;

    @Column
    private boolean obavezno;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "pitanje_anketa", joinColumns = {@JoinColumn(name = "id_pitanje", referencedColumnName = "id", nullable = false, updatable = false, table = "Pitanje")
    }, inverseJoinColumns = {@JoinColumn(name = "id_anketa", referencedColumnName = "id", nullable = false, updatable = false, table = "Anketa")})
    private List<Pitanje> pitanjeList;


    public Pitanje() {}
    public Pitanje(String tekst, boolean obavezno) {
        this.tekstPitanja = tekst;
        this.obavezno = obavezno;
    }

    public Long getId() {
        return this.id;
    }

    public String getTekstPitanja() {
        return this.tekstPitanja;
    }

    public boolean getObavezno() {
        return this.obavezno;
    }

    public void setTekstPitanja(String tekst) {
        this.tekstPitanja = tekst;
    }

    public void setObavezno(boolean obavezno) {
        this.obavezno = obavezno;
    }

}
