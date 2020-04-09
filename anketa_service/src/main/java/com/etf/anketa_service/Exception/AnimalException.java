package com.etf.anketa_service.Exception;

public class AnimalException extends RuntimeException {
    public AnimalException(Long id) {
        super("Zivotinja ciji je id " + id + " ne postoji!");
    }
}
