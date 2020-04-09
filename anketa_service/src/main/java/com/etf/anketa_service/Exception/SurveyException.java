package com.etf.anketa_service.Exception;

public class SurveyException extends RuntimeException {
    public SurveyException(Long id) {
        super("Anketa ciji je id " + id + " ne postoji!");
    }
}
