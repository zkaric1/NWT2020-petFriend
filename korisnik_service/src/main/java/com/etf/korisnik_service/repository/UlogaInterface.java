package com.etf.korisnik_service.repository;

import com.etf.korisnik_service.model.Uloga;
import org.springframework.data.repository.CrudRepository;

public interface UlogaInterface extends CrudRepository<Uloga,Integer> {
}
