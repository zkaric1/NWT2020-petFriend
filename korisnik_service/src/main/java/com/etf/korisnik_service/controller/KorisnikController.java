package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.repository.KorisnikInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("korisnik")
@RestController
public class KorisnikController {
    @Autowired
    private KorisnikInterface korisnikRepository;
}
