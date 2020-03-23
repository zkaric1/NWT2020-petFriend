package com.example.zivotinja.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Vakcina {

    // Atributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Tip;
    private int Revakcinacija; // Kad je potrebno revakcinisati zivotinju (mjeseci)

    // Relacije

    // Zivotinja n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
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
        Revakcinacija = revekcinacija;
    }
    // Setters
    public void setRevekcinacija(int revekcinacija) {
        Revakcinacija = revekcinacija;
    }
    public void setTip(String tip) {
        Tip = tip;
    }
    public void setId(Long id) { this.id = id; }

    // Getters
    public int getRevekcinacija() {
        return Revakcinacija;
    }
    public String getTip() {
        return Tip;
    }
    public Set<Zivotinja> getZivotinje() { return Zivotinje; }
    public Long getId() { return id; }
}
