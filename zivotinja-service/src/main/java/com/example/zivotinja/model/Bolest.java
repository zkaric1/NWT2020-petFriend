package com.example.zivotinja.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bolest {

    // Atributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Ime;
    private String Lijek;

    // Relacije

    // Zivotinja n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "bolest_zivotinja",
            joinColumns = {
                    @JoinColumn(name = "zivotinjaID", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "bolestID", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Zivotinja> Zivotinje = new HashSet<>();

    // Konstruktori
    public Bolest () {}
    public Bolest (String ime, String lijek) {
        Ime = ime;
        Lijek = lijek;
    }

    // Getters
    public String getLijek() {
        return Lijek;
    }
    public Set<Zivotinja> getZivotinje() { return Zivotinje; }
    public String getIme() {
        return Ime;
    }
    public Long getId() { return id; }

    // Setters
    public void setLijek(String lijek) {
        Lijek = lijek;
    }
    public void setId(Long id) { this.id = id; }
    public void setIme(String ime) {
        Ime = ime;
    }
}
