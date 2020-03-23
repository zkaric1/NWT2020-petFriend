package com.example.zivotinja.repository;

import com.example.zivotinja.model.Veterinar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinarRepository  extends JpaRepository<Veterinar, Long> {

    @Query(value = "SELECT * FROM VETERINAR WHERE ime = :ime", nativeQuery = true)
    List<Veterinar> findByName (@Param("ime") String ime);

}


