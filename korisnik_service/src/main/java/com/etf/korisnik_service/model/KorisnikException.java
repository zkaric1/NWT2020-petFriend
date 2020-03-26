package com.etf.korisnik_service.model;

public class KorisnikException extends RuntimeException{

    public KorisnikException(Integer id) {
        super("Korisnik sa id-em "+id+" ne postoji");
    }

}
