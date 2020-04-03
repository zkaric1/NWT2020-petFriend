package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.model.Role;
import com.etf.korisnik_service.repository.RoleInterface;
import com.etf.korisnik_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    //Dodavanje uloga
    @PostMapping("/uloga")
    Role dodajUlogu(@RequestBody Role role) {
        return roleService.addNewRole(role);
    }

    //Editovanje uloge
    @PutMapping("/uloga/{id}")
    void editujUlogu(@RequestBody Role novaRole, @PathVariable Integer id) throws Exception {
        roleService.editRole(novaRole,id);
    }

    //Brisanje uloge
    @DeleteMapping("/uloga/{id}")
    void obrisiUlogu(@PathVariable Integer id) throws Exception {
       roleService.deleteRole(id);
    }

    //Lista svih uloga
    @GetMapping("/uloga/lista")
    List<Role> listaUloga() {
        return roleService.getAllRoles();
    }

    //Uloga sa određenim id-em
    @GetMapping("/uloga/{id}")
    Role dajUlogu(@PathVariable Integer id) throws Exception {
        return roleService.getById(id);
    }

    @GetMapping("/uloga/naziv")
    Role dajUloguSaNazivom(@RequestParam(name = "naziv_uloge", required = false) String naziv) throws Exception {
        return roleService.getByName(naziv);
    }

    //Obrisi sve uloge
    @DeleteMapping("/uloga/obrisi_sve")
    void obrisiSveUlog() throws Exception {
        roleService.deleteAllRoles();
    }
}
