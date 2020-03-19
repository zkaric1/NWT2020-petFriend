package com.example.zivotinja.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Korisnik")
public class Korisnik {

    // Atributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relacije

    // Zivotinja n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "korisnik_zivotinja",
            joinColumns = {
                    @JoinColumn(name = "zivotinjaID", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "korisnikID", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Zivotinja> Zivotinje = new HashSet<>();

    public Korisnik () {}
}
