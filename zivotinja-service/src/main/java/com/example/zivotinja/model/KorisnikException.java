package com.example.zivotinja.model;

public class KorisnikException extends  RuntimeException{
    public KorisnikException(Long id) {
        super ("Ne postoji korisnik sa id " + id);
    }
}
