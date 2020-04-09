package com.example.zivotinja.repository;

import com.example.zivotinja.model.Korisnik;
import com.example.zivotinja.model.Zivotinja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Zivotinja WHERE korisnikid = :id", nativeQuery = true)
    void deleteZivotinjaById(@Param("id") Long id);

    @Query (value = "SELECT COUNT (zivotinjaID) FROM vakcina_zivotinja WHERE zivotinjaID = :id", nativeQuery = true)
    Integer getZivotinja (@Param ("id") Long id);

    @Query (value = "SELECT COUNT (korisnikID) FROM vakcina_zivotinja WHERE korisnikID = :id", nativeQuery = true)
    Integer getKorinik (@Param ("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM vakcina_zivotinja WHERE zivotinjaID = :id", nativeQuery = true)
    void deleteMedjuTabela(@Param("id") Long id);

}
