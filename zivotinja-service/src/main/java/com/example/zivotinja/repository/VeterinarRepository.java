package com.example.zivotinja.repository;

import com.example.zivotinja.model.Veterinar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarRepository  extends CrudRepository <Veterinar, Long>{

}


