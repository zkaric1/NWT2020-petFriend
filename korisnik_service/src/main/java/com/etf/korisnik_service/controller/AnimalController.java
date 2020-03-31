package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.repository.AnimalInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("zivotinja")
@RestController
public class AnimalController {
    @Autowired
    private AnimalInterface zivotinjaRepository;
}
