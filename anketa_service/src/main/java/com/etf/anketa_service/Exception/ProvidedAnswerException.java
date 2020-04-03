package com.etf.anketa_service.Exception;

public class ProvidedAnswerException extends RuntimeException {
    public ProvidedAnswerException() {
        super("Trazeni odgovor ne postoji!");
    }
}
