package com.example.zivotinja.model;

public class ZivotinjaException extends RuntimeException {
    public ZivotinjaException(Long id) {
            super ("Ne postoji zivotinja sa id " + id);
    }
}
