package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.model.Uloga;
import com.etf.korisnik_service.repository.UlogaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("uloga")
@RestController
public class UlogaController {
    @Autowired
    private UlogaInterface ulogaRepository;

    //Dodavanje uloga
    @PostMapping("/uloga")
    Uloga dodajUlogu(@RequestBody Uloga uloga) {
        return ulogaRepository.save(uloga);
    }

    //Editovanje uloge
    @PutMapping("/uloga/{id}")
    void editujUlogu(@RequestBody Uloga novaUloga, @PathVariable Integer id) throws Exception {
        if(!ulogaRepository.existsById(id)) {
            throw new Exception("Ne postoji uloga sa unesenim id-em");
        }
        ulogaRepository.findById(id).map(
                uloga -> {
                    uloga.setNazivUloge(uloga.getNazivUloge());
                    return ulogaRepository.save(uloga);
                }
        );
    }

    //Brisanje uloge
    @DeleteMapping("/uloga/{id}")
    void obrisiUlogu(@PathVariable Integer id) throws Exception {
        if(!ulogaRepository.existsById(id)) {
            throw new Exception("Ne postoji uloga sa tim id-em");
        }
        ulogaRepository.deleteById(id);
    }

    //Lista svih uloga
    @GetMapping("/uloga/lista")
    List<Uloga> listaUloga() {
        List<Uloga> sveUloge = new ArrayList<>();
        ulogaRepository.findAll().forEach(sveUloge::add);
        return sveUloge;
    }

    //Uloga sa određenim id-em
    @GetMapping("/uloga/{id}")
    Uloga dajUlogu(@PathVariable Integer id) throws Exception {
        if(!ulogaRepository.existsById(id)) {
            throw new Exception("Ne postoji uloga sa unesenim id-em");
        }
        return ulogaRepository.findById(id).get();
    }

    @GetMapping("/uloga/naziv")
    Uloga dajUloguSaNazivom(@RequestParam(name = "naziv_uloge",required = false) String naziv) throws Exception {
            List<Uloga> sveUloge = listaUloga();
            for (Uloga uloga : sveUloge) {
                if (uloga.getNazivUloge().equals(naziv)) {
                    return uloga;
                }
            }
            throw new Exception("Ne postoji uloga sa unesenim nazivom");
    }

    //Obrisi sve uloge
    @DeleteMapping("/uloga/obrisi_sve")
    void obrisiSveUlog() throws Exception {
        if(ulogaRepository.count() == 0) {
            throw new Exception("Ne postoji vise uloga u bazi");
        }
        ulogaRepository.deleteAll();
    }
}
