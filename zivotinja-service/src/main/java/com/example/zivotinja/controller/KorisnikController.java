package com.example.zivotinja.controller;

import com.example.zivotinja.model.Korisnik;
import com.example.zivotinja.model.Vakcina;
import com.example.zivotinja.service.KorisnikService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping ("korisnici/flag/{id}")
    public Boolean vratiFlag (@PathVariable Long id) {
        return korisnikService.findFlag(id);
    }

    // DELETE metode
    @DeleteMapping ("/korisnici/{id}")
    ResponseEntity<JSONObject> obrisiKorisnika (@PathVariable Long id) throws Exception{
        JSONObject temp = new JSONObject();
        try {
            korisnikService.deleteById(id);
            temp.put("message", "Uspjesno obrisan korisnik sa id " + id);
            return new ResponseEntity<>(
                    temp,
                    HttpStatus.OK
            );
        }
        catch (Exception e) {
            temp.put("message", "Greska pri brisanju korisnika sa id " + id);
            return new ResponseEntity<>(
                    temp,
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    // PUT metode
    // Metoda za azuriranje flaga za brisanje
    @PutMapping("/korisnici/{id}")
    ResponseEntity<JSONObject> postaviFlag( @PathVariable Long id) throws Exception {
        return korisnikService.azurirajFlag(id);
    }
}

