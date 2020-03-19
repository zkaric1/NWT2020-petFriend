package com.example.zivotinja.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.zivotinja.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("korisnik")
@RestController
public class KorisnikController {
    @Autowired
    private KorisnikRepository korisnikRepository;
}

