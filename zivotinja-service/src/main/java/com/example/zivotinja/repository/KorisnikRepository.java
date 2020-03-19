package com.example.zivotinja.repository;

import com.example.zivotinja.model.Korisnik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends CrudRepository <Korisnik, Long>{

}
