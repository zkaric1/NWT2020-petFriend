package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.repository.UlogaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("uloga")
@RestController
public class UlogaController {
    @Autowired
    private UlogaInterface ulogaRepository;
}
