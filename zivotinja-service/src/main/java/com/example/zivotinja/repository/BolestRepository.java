package com.example.zivotinja.repository;
import com.example.zivotinja.model.Bolest;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BolestRepository extends JpaRepository<Bolest, Long>{

}
