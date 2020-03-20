package com.etf.anketa_service.Repository;

import com.etf.anketa_service.Model.Pitanje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitanjeRepository extends CrudRepository<Pitanje, Long> {
}
