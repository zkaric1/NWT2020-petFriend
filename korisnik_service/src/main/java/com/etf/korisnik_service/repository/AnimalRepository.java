package com.etf.korisnik_service.repository;

import com.etf.korisnik_service.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
}
