package com.example.zivotinja.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Veterinar {

    // Atributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Ime;
    private String Prezime;
    private String kontaktTelefon; // Kad je potrebno revakcinisati zivotinju (mjeseci)
    private String Adresa;

    // Relacije

    // Zivotinja n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "veterinar_zivotinja",
            joinColumns = {
                    @JoinColumn(name = "zivotinjaID", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "veterinarID", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Zivotinja> Zivotinje = new HashSet<>();


    // Konstruktori
    public Veterinar () {}
    public Veterinar (String ime, String prezime, String telefon, String adresa) {
        Ime = ime;
        Prezime = prezime;
        kontaktTelefon = telefon;
        Adresa = adresa;
    }

    // Setters
    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    // Getters
    public String getAdresa() {
        return Adresa;
    }
    public Set<Zivotinja> getZivotinje() { return Zivotinje; }
    public String getIme() {
        return Ime;
    }
    public String getKontaktTelefon() {
        return kontaktTelefon;
    }
    public String getPrezime() { return Prezime; }
}
