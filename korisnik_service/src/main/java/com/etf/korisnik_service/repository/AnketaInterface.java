package com.etf.korisnik_service.repository;

import com.etf.korisnik_service.model.Anketa;
import org.springframework.data.repository.CrudRepository;

public interface AnketaInterface extends CrudRepository<Anketa,Integer> {
}
