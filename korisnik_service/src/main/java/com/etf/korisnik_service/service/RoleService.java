package com.etf.korisnik_service.service;

import com.etf.korisnik_service.model.Role;
import com.etf.korisnik_service.repository.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleInterface roleRepository;


    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    public void editRole(Role newRole, Integer id) throws Exception {
        if (!roleRepository.existsById(id)) {
            throw new Exception("Ne postoji uloga sa unesenim id-em");
        }
        roleRepository.findById(id).map(
                role -> {
                    role.setRoleName(newRole.getRoleName());
                    return roleRepository.save(role);
                }
        );
    }

    public void deleteRole(Integer id) throws Exception {
        if (!roleRepository.existsById(id)) {
            throw new Exception("Ne postoji uloga sa tim id-em");
        }
        roleRepository.deleteById(id);
    }

    public List<Role> getAllRoles() {
        List<Role> sveUloge = new ArrayList<>();
        roleRepository.findAll().forEach(sveUloge::add);
        return sveUloge;
    }

    public Role getById(Integer id) throws Exception {
        if (!roleRepository.existsById(id)) {
            throw new Exception("Ne postoji uloga sa unesenim id-em");
        }
        return roleRepository.findById(id).get();
    }

    public Role getByName(String naziv) throws Exception {
        List<Role> sveUloge = getAllRoles();
        for (Role role : sveUloge) {
            if (role.getRoleName().equals(naziv)) {
                return role;
            }
        }
        throw new Exception("Ne postoji uloga sa unesenim nazivom");
    }

    public void deleteAllRoles() throws Exception {
        if (roleRepository.count() == 0) {
            throw new Exception("Ne postoji vise uloga u bazi");
        }
        roleRepository.deleteAll();
    }

}
