package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.dto.LoginResponseDto;
import com.etf.korisnik_service.dto.LoginUserDto;
import com.etf.korisnik_service.dto.UserPasswordDto;
import com.etf.korisnik_service.exception.LoginException;
import com.etf.korisnik_service.model.User;
import com.etf.korisnik_service.repository.UserRepository;
import com.etf.korisnik_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Registracija korisnika POST
    @PostMapping("/korisnik")
    User dodajKorisnika(@Valid @RequestBody User noviUser) throws NoSuchAlgorithmException {
        return userService.addUser(noviUser);
    }

    //Prijava AUTH
    LoginResponseDto login(LoginUserDto user) throws LoginException {
        return userService.loginUser(user);
    }

    //Korisnik s id-em
    @GetMapping("/korisnik/{id}")
    User dajKorisnikaId(@PathVariable Integer id) throws Exception {
        return userService.getUserById(id);
    }

    //Brisanje korisnika DELETE
    @DeleteMapping("/korisnik/{id}")
    //TODO obrisat veze
    void obrisiKorsnika(@PathVariable Integer id) throws Exception {
        userService.deleteUserById(id);
    }

    //Editovanje korisnika PUT
    @PutMapping("/korisnik/{id}")
    void editujKorisnika(@RequestBody User noviUser, @PathVariable Integer id) throws Exception {
        userService.editUser(noviUser,id);
    }

    //Lista svih korisnika
    @GetMapping("/korisnik/lista")
    List<User> listaKorisnika() throws Exception {
        return userService.getListOfUsers();
    }

    //Lista svih korisnika sa odredjenom ulogom
    @GetMapping("/korisnik/uloga")
    List<User> listaKorisnikaSUlogom(@RequestParam(name = "uloga") String uloga) throws Exception {
        return userService.getAllUsersWithRole(uloga);
    }

    //Pronadji korisnika po imenu i prezimenu
    @GetMapping("/korisnik/ime_prezime/{imePrezime}")
    User dajKorisnikaSImenom(@PathVariable String imePrezime) throws Exception {
        return userService.getUserWithName(imePrezime);
    }

    //Obrisi sve korisnike
    @DeleteMapping("/korisnik/obrisi_sve")
    void obrisiSveKorisnike() throws Exception {
        userService.deleteAllUsers();
    }

    //Promijeni sifru
    @PutMapping("korisnik/sifra/{id}")
    void resetPassword(@RequestBody UserPasswordDto user, @PathVariable Integer id) {
        userService.resetPassword(id,user.getNewPassword());
    }
}
