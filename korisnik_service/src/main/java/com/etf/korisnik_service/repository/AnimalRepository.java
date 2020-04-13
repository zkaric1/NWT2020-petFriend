package com.etf.korisnik_service.repository;

import com.etf.korisnik_service.model.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
    List<Animal> findAllBySpecies(String species);
    Animal findByAnimalId(Integer id);
}
