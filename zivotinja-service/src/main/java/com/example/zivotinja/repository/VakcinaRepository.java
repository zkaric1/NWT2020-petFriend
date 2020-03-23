package com.example.zivotinja.repository;

import com.example.zivotinja.model.Vakcina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VakcinaRepository extends JpaRepository<Vakcina, Long> {

}
