package com.etf.korisnik_service.repository;

import com.etf.korisnik_service.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalInterface extends CrudRepository<Animal, Integer> {
}
