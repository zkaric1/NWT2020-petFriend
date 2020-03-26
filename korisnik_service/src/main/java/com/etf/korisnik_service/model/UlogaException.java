package com.etf.korisnik_service.model;

public class UlogaException extends RuntimeException {

    public UlogaException(Integer id) {
        super("Ne postoji uloga sa id-em "+id);
    }
}
