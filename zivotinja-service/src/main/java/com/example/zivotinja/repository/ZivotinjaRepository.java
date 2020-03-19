package com.example.zivotinja.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.zivotinja.model.Zivotinja;
import org.springframework.stereotype.Repository;

@Repository
public interface ZivotinjaRepository extends CrudRepository <Zivotinja, Long>{

}
