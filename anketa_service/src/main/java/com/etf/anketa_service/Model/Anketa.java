package com.etf.anketa_service.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Anketa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String opis;

    @Column
    private boolean aktivna;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "pitanje_anketa", joinColumns = {@JoinColumn(name = "id_anketa", referencedColumnName = "id", nullable = false, updatable = false, table = "Anketa")
    }, inverseJoinColumns = {@JoinColumn(name = "id_pitanje", referencedColumnName = "id", nullable = false, updatable = false, table = "Pitanje")})
    private List<Anketa> anketaList;

    public Anketa() {}

    public Anketa(String opis, boolean aktivna) {
        this.opis = opis;
        this.aktivna = aktivna;
    }

    public String getOpis() {
        return this.opis;
    }

    public boolean getAktivna() {
        return this.aktivna;
    }

    public Long getId() {
        return this.id;
    }

    public void setAktivna(boolean aktivna) {
        this.aktivna = aktivna;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
