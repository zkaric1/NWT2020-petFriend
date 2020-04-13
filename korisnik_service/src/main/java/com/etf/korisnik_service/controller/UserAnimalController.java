package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.model.Animal;
import com.etf.korisnik_service.model.UserAnimal;
import com.etf.korisnik_service.repository.UserAnimalRepository;
import com.etf.korisnik_service.service.AnimalService;
import com.etf.korisnik_service.service.UserAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserAnimalController {

    @Autowired
    private RestTemplate restTemplate;

    private AnimalService animalService;

    private UserAnimalService userAnimalService;

    public UserAnimalController(UserAnimalService userAnimalService) {
        this.userAnimalService = userAnimalService;
    }

    @GetMapping(value = "/user_animal/dajZivotinju/{idKorisnika}", produces = "application/xml")
    public String dajZivotinjuOdKorisnika(@PathVariable Integer idKorisnika) throws Exception {
        String response = restTemplate.exchange("http://zivotinjaService/zivotinje", //a/korisnik"
                HttpMethod.GET, null,String.class).getBody();
        return response;
//        return new ResponseEntity<>(
//                response,
//                HttpStatus.OK
//        );
    }
}
