package com.etf.korisnik_service.model;

import javax.persistence.*;
import java.util.Date;

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
    private
}

