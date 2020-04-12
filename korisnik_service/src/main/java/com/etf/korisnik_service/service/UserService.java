package com.etf.korisnik_service.service;

import com.etf.korisnik_service.dto.LoginResponseDto;
import com.etf.korisnik_service.dto.LoginUserDto;
import com.etf.korisnik_service.dto.MessageDto;
import com.etf.korisnik_service.exception.LoginException;
import com.etf.korisnik_service.exception.UserException;
import com.etf.korisnik_service.model.Role;
import com.etf.korisnik_service.model.User;
import com.etf.korisnik_service.model.UserAnimal;
import com.etf.korisnik_service.repository.UserAnimalRepository;
import com.etf.korisnik_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAnimalRepository userAnimalRepository;
    @Autowired
    private RoleService roleService;

    private List<User> sviKorisnici;

    public User addUser(User noviUser) {
        noviUser.setPassword(hashPassword(noviUser.getPassword()));
        return userRepository.save(noviUser);
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPassword = passwordEncoder.encode(password);
        return hashPassword;
    }

    public LoginResponseDto loginUser(LoginUserDto user) throws LoginException {
        return null;
    }

    private String generateToken() {return null;}

    public User getUserById(Integer id) throws UserException {
        return userRepository.findById(id).orElseThrow(() -> new UserException(id));
    }

    public HashMap<String,String> deleteUserById(Integer id) throws UserException {
        if (!userRepository.existsById(id)) {
            throw new UserException(id);
        }
        deleteDependecies(id);
        userRepository.deleteById(id);
        return new MessageDto("Uspjesno orbisan korisnik sa id-em "+id).getHashMap();
    }

    public User editUser(User noviUser, Integer id) throws UserException {
        userRepository.findById(id).orElseThrow(() -> new UserException(id));
        userRepository.findById(id).map(
                user -> {
                    user.setFullName(noviUser.getFullName());
                    user.setAddress(noviUser.getAddress());
                    user.setEmail(noviUser.getEmail());
                    user.setPhoneNumber(noviUser.getPhoneNumber());
                    return userRepository.save(user);
                }
        );
        return userRepository.findById(id).get();
    }

    public HashMap<String,String> resetPassword(Integer userId, String newPassword) throws UserException {
        if(!userRepository.existsById(userId)) {
            throw new UserException(userId);
        }
        userRepository.findById(userId).map(user -> {
            user.setPassword(hashPassword(newPassword));
            return userRepository.save(user);
        });
        return new MessageDto("Uspjesno promijenjena sifra").getHashMap();
    }

    public HashMap<String,String> resetEmail(Integer userId, String newEmail) throws UserException {
        if(!userRepository.existsById(userId)) {
            throw new UserException(userId);
        }
        userRepository.findById(userId).map(user -> {
            user.setEmail(newEmail);
            return userRepository.save(user);
        });
        return new MessageDto("Uspjesno promijenjen email").getHashMap();
    }

    public User changeRole(Integer userId, String roleName) throws Exception {
        Role newRole = roleService.getByName(roleName);
        if(!userRepository.existsById(userId)) {
            throw new UserException(userId);
        }
        userRepository.findById(userId).map(user -> {
            user.setRole(newRole);
            return userRepository.save(user);
        });

        return userRepository.findById(userId).get();
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
            if (user.getRole() != null && user.getRole().getRoleName().equals(uloga)) {
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

    public HashMap<String,String> deleteAllUsers()  throws Exception {
        if (userRepository.count() == 0) {
            throw new Exception("U bazi nema vise korisnika");
        }
        deleteDependecies(-1);
        userRepository.deleteAll();
        return new MessageDto("Uspjesno obrisani korisnici").getHashMap();
    }

    private void deleteDependecies(Integer userId) {
        List<UserAnimal> userAnimalsList = new ArrayList<>();
        userAnimalRepository.findAll().forEach(userAnimalsList::add);
        for (UserAnimal userAnimal: userAnimalsList) {
            if(userId == -1) {
                userAnimalRepository.deleteAll();
                return;
            }
            else if(userAnimal.getUser().getId() == userId) {
                userAnimalRepository.deleteById(userAnimal.getId());
            }
        }
    }

}
