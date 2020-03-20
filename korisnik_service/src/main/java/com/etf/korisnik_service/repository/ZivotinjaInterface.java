package com.etf.korisnik_service.repository;

import com.etf.korisnik_service.model.Zivotinja;
import org.springframework.data.repository.CrudRepository;

public interface ZivotinjaInterface extends CrudRepository<Zivotinja,Integer> {
}
