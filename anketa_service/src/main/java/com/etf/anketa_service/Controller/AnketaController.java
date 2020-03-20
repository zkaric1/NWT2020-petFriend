package com.etf.anketa_service.Controller;

import com.etf.anketa_service.Repository.AnketaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("anketa")
@RestController
public class AnketaController {
    @Autowired
    private AnketaRepository anketaRepository;
}
