package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.model.Animal;
import com.etf.korisnik_service.model.UserAnimal;
import com.etf.korisnik_service.repository.UserAnimalRepository;
import com.etf.korisnik_service.service.AnimalService;
import com.etf.korisnik_service.service.UserAnimalService;
import com.github.underscore.lodash.U;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserAnimalController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AnimalService animalService;

    private UserAnimalService userAnimalService;

    public UserAnimalController(UserAnimalService userAnimalService) {
        this.userAnimalService = userAnimalService;
    }

    @GetMapping(value = "/user_animal/dajZivotinju/{idKorisnika}", produces = "application/xml")
    public JSONObject dajZivotinjuOdKorisnika(@PathVariable Integer idKorisnika) throws Exception {
        String response = restTemplate.exchange("http://zivotinjaService/zivotinje", //a/korisnik"
                HttpMethod.GET, null,String.class).getBody();
        JSONObject jsonArray = XML.toJSONObject(response); //U.xmlToJson(response);

        JSONObject json = new JSONObject(jsonArray);
        return jsonArray;
    }

    @GetMapping(value = "user_animal/sveZivotinje",produces ="application/xml")
    public String dajSveZivotinje() throws Exception {
        String response = restTemplate.exchange("http://zivotinjaService/zivotinje", //a/korisnik"
                HttpMethod.GET, null,String.class).getBody();
        return response;
    }
}
