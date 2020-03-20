package com.etf.korisnik_service.model;

import net.bytebuddy.matcher.StringMatcher;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Korinsik")
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String imePrezime;
    private Date datumRodjenja;
    private String email;
    private String sifra;
    private String adresa;
    private String telefon;
    private String maticniBroj;
    private String spol;
    @OneToMany(mappedBy = "uloga")
    private List<Uloga> ulogaList;

    public Korisnik(String imePrezime, Date datumRodjenja, String email, String sifra, String adresa, String telefon, String maticniBroj, String spol) {
        this.imePrezime = imePrezime;
        this.datumRodjenja = datumRodjenja;
        this.email = email;
        this.sifra = sifra;
        this.adresa = adresa;
        this.telefon = telefon;
        this.maticniBroj = maticniBroj;
        this.spol = spol;
    }

    public Korisnik(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    public List<Uloga> getUlogaList() {
        return ulogaList;
    }

    public void setUlogaList(List<Uloga> ulogaList) {
        this.ulogaList = ulogaList;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", imePrezime='" + imePrezime + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", email='" + email + '\'' +
                ", sifra='" + sifra + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                ", maticniBroj='" + maticniBroj + '\'' +
                ", spol='" + spol + '\'' +
                ", ulogaList=" + ulogaList +
                '}';
    }
}

