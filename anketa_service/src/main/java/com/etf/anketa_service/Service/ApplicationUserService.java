package com.etf.anketa_service.Service;

import com.etf.anketa_service.Exception.ApplicationUserException;
import com.etf.anketa_service.Model.ApplicationUser;
import com.etf.anketa_service.Repository.ApplicationUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserService {
    private ApplicationUserRepository applicationUserRepository;

    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    public List<ApplicationUser> getAll() {
        return applicationUserRepository.findAll();
    }

    public ApplicationUser findById(Long id) {
        return applicationUserRepository.findById(id).orElseThrow(() -> new ApplicationUserException(id));
    }

    public void deleteById(Long id) throws Exception {
        applicationUserRepository.deleteById(id);
    }
}