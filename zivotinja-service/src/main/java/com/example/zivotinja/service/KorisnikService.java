package com.example.zivotinja.service;
import java.util.*;
import com.example.zivotinja.exception.KorisnikException;
import com.example.zivotinja.model.Bolest;
import com.example.zivotinja.model.Korisnik;
import com.example.zivotinja.model.Zivotinja;
import com.example.zivotinja.repository.KorisnikRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    public Korisnik findById(Long id) {
        return korisnikRepository.findById(id).orElseThrow(() -> new KorisnikException(id));
    }

    public void deleteById (Long id) throws Exception {
        Integer brojZivotinja = korisnikRepository.getZivotinja(id);
        if (brojZivotinja != 0) korisnikRepository.deleteMedjuTabela(id);
        korisnikRepository.deleteZivotinjaById(id);
        korisnikRepository.deleteById(id);
    }

    public Boolean findFlag (long id) {
        return korisnikRepository.findFlag(id);
    }

    public Korisnik put(Korisnik noviKorisnik, Long id) throws Exception {
        if (!korisnikRepository.existsById(id)) {
            throw new Exception("Korisnik sa id " + id + " ne postoji u bazi!");
        }
        return korisnikRepository.findById(id)
                .map(korisnik -> {
                    korisnik.setBrisati(noviKorisnik.getBrisati());
                    return korisnikRepository.save(korisnik);
                })
                .orElseGet(() -> {
                    noviKorisnik.setId(id);
                    return korisnikRepository.save(noviKorisnik);
                });
    }

    public ResponseEntity<JSONObject> azurirajFlag( Long id) throws Exception {
        if (!korisnikRepository.existsById(id)) {
            throw new Exception("Ne postoji korisnik sa trazenim id " + id);
        }
        JSONObject temp = new JSONObject();
        try {
            Korisnik noviKorisnik = findById(id);
            noviKorisnik.setBrisati(true);
            put(noviKorisnik, id);
            temp.put("message", "Uspjesno postavljen flag na true za korisnika sa id " + id);
            return new ResponseEntity<>(
                    temp,
                    HttpStatus.OK
            );
        }
        catch (Exception e) {
            temp.put("message", "Greska pri postavljanju flaga korisnika sa id " + id);
            return new ResponseEntity<>(
                    temp,
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
