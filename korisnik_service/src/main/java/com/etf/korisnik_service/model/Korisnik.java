package com.etf.korisnik_service.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Korisnik")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Ime i prezime su obavezni!")
    @Pattern(regexp = "[A-Za-z \\s-]*", message = "Nije validan unos imena i prezimena")
    private String imePrezime;

   // @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Datum mora biti formata dd/mm/yyyy")
    private Date datumRodjenja;

    @Pattern(regexp = "/^\\S+@\\S+\\.\\S+$/", message = "Email nije dobrog formata")
    private String email;

    @Pattern(regexp = "[\\w\\d]{7,}", message = "Sifra mora imati minimalno 7 znakova (karaktera ili brojeva)")
    private String sifra;

    @Pattern(regexp = "[A-Za-z \\s-]*", message = "Nije validan unos adrese")
    private String adresa;

    private String telefon;

    @NotBlank(message = "Maticni broj je obavezan")
    private String maticniBroj;

    @Pattern(regexp = "^(M|Z)$", message = "Spol moze biti M ili Z")
    private String spol;

    @ManyToOne
    @JoinColumn(name = "ulogaId", referencedColumnName = "id")
    private Uloga ulogaId;

    public Korisnik() {}

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

    public Korisnik(String imePrezime, String maticniBroj, Uloga uloga) {
        this.imePrezime = imePrezime;
        this.maticniBroj = maticniBroj;
        this.ulogaId = uloga;
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

    public Uloga getUlogaId() {
        return ulogaId;
    }

    public void setUlogaId(Uloga ulogaId) {
        this.ulogaId = ulogaId;
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
                '}';
    }
}

