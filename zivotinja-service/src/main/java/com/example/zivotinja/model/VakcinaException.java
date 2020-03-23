package com.example.zivotinja.model;

public class VakcinaException extends RuntimeException {
    public VakcinaException(Long id) {
        super ("Ne postoji vakcina sa id " + id);
    }
}
