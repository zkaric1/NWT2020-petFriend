package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.model.Role;
import com.etf.korisnik_service.repository.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("uloga")
@RestController
public class RoleController {
    @Autowired
    private RoleInterface ulogaRepository;

    //Dodavanje uloga
    @PostMapping("/uloga")
    Role dodajUlogu(@RequestBody Role role) {
        return ulogaRepository.save(role);
    }

    //Editovanje uloge
    @PutMapping("/uloga/{id}")
    void editujUlogu(@RequestBody Role novaRole, @PathVariable Integer id) throws Exception {
        if (!ulogaRepository.existsById(id)) {
            throw new Exception("Ne postoji uloga sa unesenim id-em");
        }
        ulogaRepository.findById(id).map(
                role -> {
                    role.setRoleName(role.getRoleName());
                    return ulogaRepository.save(role);
                }
        );
    }

    //Brisanje uloge
    @DeleteMapping("/uloga/{id}")
    void obrisiUlogu(@PathVariable Integer id) throws Exception {
        if (!ulogaRepository.existsById(id)) {
            throw new Exception("Ne postoji uloga sa tim id-em");
        }
        ulogaRepository.deleteById(id);
    }

    //Lista svih uloga
    @GetMapping("/uloga/lista")
    List<Role> listaUloga() {
        List<Role> sveUloge = new ArrayList<>();
        ulogaRepository.findAll().forEach(sveUloge::add);
        return sveUloge;
    }

    //Uloga sa određenim id-em
    @GetMapping("/uloga/{id}")
    Role dajUlogu(@PathVariable Integer id) throws Exception {
        if (!ulogaRepository.existsById(id)) {
            throw new Exception("Ne postoji uloga sa unesenim id-em");
        }
        return ulogaRepository.findById(id).get();
    }

    @GetMapping("/uloga/naziv")
    Role dajUloguSaNazivom(@RequestParam(name = "naziv_uloge", required = false) String naziv) throws Exception {
        List<Role> sveUloge = listaUloga();
        for (Role role : sveUloge) {
            if (role.getRoleName().equals(naziv)) {
                return role;
            }
        }
        throw new Exception("Ne postoji uloga sa unesenim nazivom");
    }

    //Obrisi sve uloge
    @DeleteMapping("/uloga/obrisi_sve")
    void obrisiSveUlog() throws Exception {
        if (ulogaRepository.count() == 0) {
            throw new Exception("Ne postoji vise uloga u bazi");
        }
        ulogaRepository.deleteAll();
    }
}
