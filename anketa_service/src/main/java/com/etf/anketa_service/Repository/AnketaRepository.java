package com.etf.anketa_service.Repository;

import com.etf.anketa_service.Model.Anketa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnketaRepository extends CrudRepository<Anketa, Long> {

}
