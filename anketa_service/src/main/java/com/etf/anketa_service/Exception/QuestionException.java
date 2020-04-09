package com.etf.anketa_service.Exception;

public class QuestionException extends RuntimeException {
    public QuestionException(Long id) {
        super("Pitanje ciji je id " + id + " ne postoji!");
    }
}
