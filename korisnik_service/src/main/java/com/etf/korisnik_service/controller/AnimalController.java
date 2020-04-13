package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.model.Animal;
import com.etf.korisnik_service.repository.AnimalRepository;
import com.etf.korisnik_service.service.AnimalService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping("/zivotinja")
    public Animal sacuvajZivotinju(@RequestBody Animal animal) throws Exception {
        return animalService.sacuvajZivotinju(animal);
    }

    @GetMapping("/zivotinja/vrsta/{vrsta}")
    public List<Animal> dajZivotinjeSVrstom(@PathVariable String vrsta) throws Exception {
        return animalService.dajZivotinjuVrste(vrsta);
    }

    @GetMapping("/zivotinja/id")
    public Animal dajZivotinjuSId(@RequestParam(name = "zivotinjaId") Integer id) throws Exception {
        return animalService.dajZivotinjuSaId(id);
    }
}
