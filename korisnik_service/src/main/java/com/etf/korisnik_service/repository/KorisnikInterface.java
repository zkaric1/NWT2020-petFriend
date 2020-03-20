package com.etf.korisnik_service.repository;

import com.etf.korisnik_service.model.Korisnik;
import org.springframework.data.repository.CrudRepository;

public interface KorisnikInterface extends CrudRepository<Korisnik,Integer> {
}
