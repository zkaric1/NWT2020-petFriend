package com.example.zivotinja.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

@Entity
public class Korisnik {

    // Atributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacije

    // Zivotinja n-n
    @OneToMany(mappedBy = "korisnikId")
    private List<Zivotinja> zivotinje;

    public Korisnik() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public List<Zivotinja> getZivotinje() {
        return zivotinje;
    }
}
