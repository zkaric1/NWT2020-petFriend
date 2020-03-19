package com.example.zivotinja.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Bolest")
public class Bolest {

    // Atributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Ime;
    private String Lijek;

    // Relacije

    // Zivotinja n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "bolest_zivotinja",
            joinColumns = {
                    @JoinColumn(name = "zivotinjaID", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "bolestID", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Zivotinja> Zivotinje = new HashSet<>();

    // Konstruktor
    public Bolest () {}
    public Bolest (String ime, String lijek) {
        Ime = ime;
        Lijek = lijek;
    }

    // Getters
    public String getLijek() {
        return Lijek;
    }

    public String getIme() {
        return Ime;
    }

    // Setters
    public void setLijek(String lijek) {
        Lijek = lijek;
    }

    public void setIme(String ime) {
        Ime = ime;
    }
}
