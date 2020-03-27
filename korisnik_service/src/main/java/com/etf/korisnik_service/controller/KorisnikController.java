package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.model.Korisnik;
import com.etf.korisnik_service.model.KorisnikException;
import com.etf.korisnik_service.model.Uloga;
import com.etf.korisnik_service.repository.KorisnikInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//@RequestMapping("korisnik")
@RestController
public class KorisnikController {
    @Autowired
    private KorisnikInterface korisnikRepository;

    private UlogaController ulogaController;

    //Registracija korisnika POST
    @PostMapping("/korisnik")
    Korisnik dodajKorisnika (@Valid @RequestBody Korisnik noviKorisnik) {
        return korisnikRepository.save(noviKorisnik);
    }

    //Prijava


    //Korisnik s id-em
    @GetMapping("/korisnik/{id}")
    Korisnik dajKorisnikaId(@PathVariable Integer id) throws Exception {
        return korisnikRepository.findById(id).orElseThrow(() -> new KorisnikException(id));
    }

    //Brisanje korisnika DELETE
    @DeleteMapping("/korisnik/{id}")  //TODO obrisat veze
    void obrisiKorsnika(@PathVariable Integer id) throws Exception {
        if(!korisnikRepository.existsById(id)) {
            throw new Exception("Ne postoji korisnik sa "+ id +" id-em");
        }
        korisnikRepository.deleteById(id);
    }

    //Editovanje korisnika PUT
    @PutMapping("/korisnik/{id}")
    void editujKorisnika(@RequestBody Korisnik noviKorisnik, @PathVariable Integer id) throws Exception {
        korisnikRepository.findById(id).orElseThrow(() ->new Exception("Ne postoji korisnik sa "+id+" id-em"));
        korisnikRepository.findById(id).map(
                korisnik -> {
                    korisnik.setImePrezime(noviKorisnik.getImePrezime());
                    korisnik.setAdresa(noviKorisnik.getAdresa());
                    korisnik.setEmail(noviKorisnik.getEmail());
                    korisnik.setTelefon(noviKorisnik.getTelefon());
                    return korisnikRepository.save(korisnik);
                }
        );
    }

    //Lista svih korisnika
    @GetMapping("/korisnik/lista")
    List<Korisnik> listaKorisnika() throws Exception {
        if(korisnikRepository.count() == 0) {
            throw new Exception("Nema korisnika u bazi");
        }
        List<Korisnik> sviKorisnici = new ArrayList<>();
        korisnikRepository.findAll().forEach(sviKorisnici::add);
        return sviKorisnici;
    }

    //Lista svih korisnika sa odredjenom ulogom
    @GetMapping("/korisnik/uloga")
    List<Korisnik> listaKorisnikaSUlogom(@RequestParam(name = "uloga") String uloga) throws Exception {
        Uloga uloga1 = ulogaController.dajUloguSaNazivom(uloga);
        List<Korisnik> sviKorisnici = listaKorisnika();
        List<Korisnik> korisnici = new ArrayList<>();
        for (Korisnik korisnik: sviKorisnici) {
            if(korisnik.getUlogaId().equals(uloga1.getId())) {
                korisnici.add(korisnik);
            }
        }
        return korisnici;
    }

    //Pronadji korisnika po imenu i prezimenu
    //@GetMapping("/korisnik/{ime_prezime}")

    //Obrisi sve korisnike
    @DeleteMapping("/korisnik/obrisi")
    void obrisiSveKorisnike() throws Exception {
        if(korisnikRepository.count() == 0) {
            throw new Exception("U bazi nema vise korisnika");
        }
        korisnikRepository.deleteAll();
    }
}
