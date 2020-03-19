package com.example.zivotinja.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Vakcina")
public class Vakcina {

    // Atributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Tip;
    private int Revekcinacija; // Kad je potrebno revakcinisati zivotinju (mjeseci)

    // Relacije

    // Zivotinja n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "vakcina_zivotinja",
            joinColumns = {
                    @JoinColumn(name = "zivotinjaID", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "vakcinaID", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Zivotinja> Zivotinje = new HashSet<>();

    // Konstruktori
    public Vakcina () {}
    public Vakcina (String tip, int revekcinacija) {
        Tip = tip;
        Revekcinacija = revekcinacija;
    }
    // Setters
    public void setRevekcinacija(int revekcinacija) {
        Revekcinacija = revekcinacija;
    }

    public void setTip(String tip) {
        Tip = tip;
    }

    // Getters
    public int getRevekcinacija() {
        return Revekcinacija;
    }

    public String getTip() {
        return Tip;
    }

}
