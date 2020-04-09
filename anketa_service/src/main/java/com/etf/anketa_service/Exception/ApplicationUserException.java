package com.etf.anketa_service.Exception;

public class ApplicationUserException extends RuntimeException {
    public ApplicationUserException(Long id) {
        super("Korisnik ciji je id " + id + " ne postoji!");
    }
}
