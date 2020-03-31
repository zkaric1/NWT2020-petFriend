package com.etf.korisnik_service.model;

import javax.persistence.*;

@Entity
@Table(name = "Zivotinja")
public class Zivotinja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String vrsta;
    private String spol;

    public Zivotinja() {}

    public Zivotinja(String vrsta, String spol) {
        this.vrsta = vrsta;
        this.spol = spol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    @Override
    public String toString() {
        return "Zivotinja{" +
                "id=" + id +
                ", vrsta='" + vrsta + '\'' +
                ", spol='" + spol + '\'' +
                '}';
    }
}

