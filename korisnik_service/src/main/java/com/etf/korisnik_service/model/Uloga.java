package com.etf.korisnik_service.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "uloga")
public class Uloga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Naziv uloge ne moze biti prazan")
    private String nazivUloge;

    public Uloga() {}

    public Uloga(String naziv) {
        nazivUloge = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivUloge() {
        return nazivUloge;
    }

    public void setNazivUloge(String nazivUloge) {
        this.nazivUloge = nazivUloge;
    }

    @Override
    public String toString() {
        return "Uloga{" +
                "id=" + id +
                ", nazivUloge='" + nazivUloge + '\'' +
                '}';
    }
}
