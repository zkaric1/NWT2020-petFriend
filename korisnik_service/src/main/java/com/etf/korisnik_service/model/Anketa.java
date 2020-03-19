package com.etf.korisnik_service.model;


import javax.persistence.*;


@Entity
@Table(name = "anketa")
public class Anketa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Anketa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
