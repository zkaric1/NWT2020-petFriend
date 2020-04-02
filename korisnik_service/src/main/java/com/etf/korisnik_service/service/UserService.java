package com.etf.korisnik_service.service;

import com.etf.korisnik_service.exception.UserException;
import com.etf.korisnik_service.model.Role;
import com.etf.korisnik_service.model.User;
import com.etf.korisnik_service.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserInterface userRepository;
    private List<User> sviKorisnici;

    public User addUser(User noviUser) {
        return userRepository.save(noviUser);
    }

    public User getUserById(Integer id) throws UserException {
        return userRepository.findById(id).orElseThrow(() -> new UserException(id));
    }

    public void deleteUserById(Integer id) throws Exception {
        if (!userRepository.existsById(id)) {
            throw new Exception("Ne postoji korisnik sa " + id + " id-em");
        }
        userRepository.deleteById(id);
    }

    public void editUser(User noviUser, Integer id) throws Exception {
        userRepository.findById(id).orElseThrow(() -> new Exception("Ne postoji korisnik sa " + id + " id-em"));
        userRepository.findById(id).map(
                user -> {
                    user.setFullName(noviUser.getFullName());
                    user.setAddress(noviUser.getAddress());
                    user.setEmail(noviUser.getEmail());
                    user.setPhoneNumber(noviUser.getPhoneNumber());
                    return userRepository.save(user);
                }
        );
    }

    public List<User> getListOfUsers() throws Exception {
        if (userRepository.count() == 0) {
            throw new Exception("Nema korisnika u bazi");
        }
        List<User> sviKorisnici = new ArrayList<>();
        userRepository.findAll().forEach(sviKorisnici::add);
        return sviKorisnici;
    }

    public List<User> getAllUsersWithRole(String uloga) throws Exception {
        sviKorisnici = getListOfUsers();
        List<User> korisnici = new ArrayList<>();
        for (User user : sviKorisnici) {
            if (user.getRoleId() != null && user.getRoleId().getRoleName().equals(uloga)) {
                korisnici.add(user);
            }
        }
        if (korisnici.size() == 0) {
            throw new Exception("Nema korisnika sa tom ulogom");
        }
        return korisnici;
    }

    public User getUserWithName(String imePrezime) throws Exception {
        sviKorisnici = getListOfUsers();
        for (User user : sviKorisnici) {
            if (user.getFullName() != null && user.getFullName().equals(imePrezime)) {
                return user;
            }
        }
        throw new Exception("Nema korisnika sa tom ulogom");
    }

    public void deleteAllUsers()  throws Exception {
        if (userRepository.count() == 0) {
            throw new Exception("U bazi nema vise korisnika");
        }
        userRepository.deleteAll();
    }

}
