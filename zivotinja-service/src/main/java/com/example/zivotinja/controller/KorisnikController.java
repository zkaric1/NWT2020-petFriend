package com.example.zivotinja.controller;

import com.example.zivotinja.model.Korisnik;
import com.example.zivotinja.service.KorisnikService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KorisnikController {

    private KorisnikService korisnikService;

    KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    // GET metode
    @GetMapping("/korisnici")
    List<Korisnik> all() {
        return korisnikService.findAll();
    }

    @GetMapping("/korisnici/{id}")
    public Korisnik one(@PathVariable Long id) {
        return korisnikService.findById(id);
    }

    @DeleteMapping ("/korisnici/{id}")
    void obrisiKorisnika (@PathVariable Long id) throws Exception{
        korisnikService.deleteById(id);
    }
}

