package com.example.zivotinja.repository;

import com.example.zivotinja.model.Bolest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolestRepository extends CrudRepository <Bolest, Long>{

}
