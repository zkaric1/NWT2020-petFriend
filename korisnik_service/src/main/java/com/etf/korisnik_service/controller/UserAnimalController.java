package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.repository.UserAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("korisnik_zivotinja")
@RestController
public class UserAnimalController {
    @Autowired
    private UserAnimalRepository korisnikZivotinjaRepository;
}
