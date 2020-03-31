package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.model.User;
import com.etf.korisnik_service.exception.UserException;
import com.etf.korisnik_service.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserInterface korisnikRepository;

    List<User> sviKorisnici;

    //Registracija korisnika POST
    @PostMapping("/korisnik")
    User dodajKorisnika(@Valid @RequestBody User noviUser) {
        return korisnikRepository.save(noviUser);
    }

    //Prijava


    //Korisnik s id-em
    @GetMapping("/korisnik/{id}")
    User dajKorisnikaId(@PathVariable Integer id) throws Exception {
        return korisnikRepository.findById(id).orElseThrow(() -> new UserException(id));
    }

    //Brisanje korisnika DELETE
    @DeleteMapping("/korisnik/{id}")
    //TODO obrisat veze
    void obrisiKorsnika(@PathVariable Integer id) throws Exception {
        if (!korisnikRepository.existsById(id)) {
            throw new Exception("Ne postoji korisnik sa " + id + " id-em");
        }
        korisnikRepository.deleteById(id);
    }

    //Editovanje korisnika PUT
    @PutMapping("/korisnik/{id}")
    void editujKorisnika(@RequestBody User noviUser, @PathVariable Integer id) throws Exception {
        korisnikRepository.findById(id).orElseThrow(() -> new Exception("Ne postoji korisnik sa " + id + " id-em"));
        korisnikRepository.findById(id).map(
                user -> {
                    user.setFullName(noviUser.getFullName());
                    user.setAddress(noviUser.getAddress());
                    user.setEmail(noviUser.getEmail());
                    user.setPhoneNumber(noviUser.getPhoneNumber());
                    return korisnikRepository.save(user);
                }
        );
    }

    //Lista svih korisnika
    @GetMapping("/korisnik/lista")
    List<User> listaKorisnika() throws Exception {
        if (korisnikRepository.count() == 0) {
            throw new Exception("Nema korisnika u bazi");
        }
        List<User> sviKorisnici = new ArrayList<>();
        korisnikRepository.findAll().forEach(sviKorisnici::add);
        return sviKorisnici;
    }

    //Lista svih korisnika sa odredjenom ulogom
    @GetMapping("/korisnik/uloga")
    //TODO ne moze kontroler
    List<User> listaKorisnikaSUlogom(@RequestParam(name = "uloga") String uloga) throws Exception {
        sviKorisnici = listaKorisnika();
        List<User> korisnici = new ArrayList<>();
        for (User user : sviKorisnici) {
            if (user.getRoleId() != null && user.getRoleId().getRoleName().equals(uloga)) {
                korisnici.add(user);
            }
        }
        if (korisnici.size() == 0) {
            throw new Exception("Nema korisnika sa tom ulogom");
        }
        return korisnici;
    }

    //Pronadji korisnika po imenu i prezimenu
    @GetMapping("/korisnik/ime_prezime/{imePrezime}")
    User dajKorisnikaSImenom(@PathVariable String imePrezime) throws Exception {
        sviKorisnici = listaKorisnika();
        for (User user : sviKorisnici) {
            if (user.getFullName() != null && user.getFullName().equals(imePrezime)) {
                return user;
            }
        }
        throw new Exception("Nema korisnika sa tom ulogom");
    }

    //Obrisi sve korisnike
    @DeleteMapping("/korisnik/obrisi_sve")
    void obrisiSveKorisnike() throws Exception {
        if (korisnikRepository.count() == 0) {
            throw new Exception("U bazi nema vise korisnika");
        }
        korisnikRepository.deleteAll();
    }
}
