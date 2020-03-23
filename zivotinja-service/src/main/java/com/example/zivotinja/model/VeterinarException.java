package com.example.zivotinja.model;

public class VeterinarException extends RuntimeException {
    public VeterinarException(Long id) {
        super ("Ne postoji veterinar sa id " + id);
    }
}
