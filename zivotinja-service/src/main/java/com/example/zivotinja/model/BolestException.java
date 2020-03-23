package com.example.zivotinja.model;

public class BolestException extends RuntimeException{
    public BolestException(Long id) {
        super ("Ne postoji bolest sa id " + id);
    }
}
