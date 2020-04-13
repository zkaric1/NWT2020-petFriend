package com.etf.korisnik_service.service;

import com.etf.korisnik_service.DTO.ResponseMessageDTO;
import com.etf.korisnik_service.model.Animal;
import com.etf.korisnik_service.model.User;
import com.etf.korisnik_service.model.UserAnimal;
import com.etf.korisnik_service.repository.UserAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class UserAnimalService {

    @Autowired
    private UserAnimalRepository userAnimalRepository;

    public HashMap<String,String> spasiPodatke(User user, Animal animal) {
        UserAnimal userAnimal = new UserAnimal(user,animal);
        userAnimalRepository.save(userAnimal);
        return new ResponseMessageDTO("Uspjesno spasena veza zivotinja-korisnik").getHashMap();
    }
}
