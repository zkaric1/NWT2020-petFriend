package com.example.zivotinja.service;

import java.util.*;

import com.example.zivotinja.exception.KorisnikException;
import com.example.zivotinja.model.Korisnik;
import com.example.zivotinja.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    public Korisnik findById(Long id) {
        return korisnikRepository.findById(id).orElseThrow(() -> new KorisnikException(id));
    }
}
