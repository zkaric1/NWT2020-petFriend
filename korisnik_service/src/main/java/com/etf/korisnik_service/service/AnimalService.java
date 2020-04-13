package com.etf.korisnik_service.service;

import com.etf.korisnik_service.model.Animal;
import com.etf.korisnik_service.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Animal sacuvajZivotinju(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> dajZivotinjuVrste(String vrsta) throws Exception {
        List<Animal> lista = animalRepository.findAllBySpecies(vrsta);
        if(lista.size() == 0) {
            throw new Exception("Ne postoji zivotinja navedene vrste");
        }
        return lista;
    }

    public Animal dajZivotinjuSaId(Integer id) throws Exception {
        Animal animal = animalRepository.findByAnimalId(id);
        if(animal == null) {
            throw  new Exception("Ne postoji zivotinja s id-em "+id);
        }
        return animal;
    }


}
