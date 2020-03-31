package com.etf.korisnik_service.service;

import com.etf.korisnik_service.model.Role;
import com.etf.korisnik_service.repository.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRoleService {
    @Autowired
    private RoleInterface roleRepository;


    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

}
