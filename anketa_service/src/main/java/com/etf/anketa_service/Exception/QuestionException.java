package com.etf.anketa_service.Exception;

public class QuestionException extends RuntimeException {
    public QuestionException() {
        super("Trazeni korisnik ne postoji!");
    }
}
