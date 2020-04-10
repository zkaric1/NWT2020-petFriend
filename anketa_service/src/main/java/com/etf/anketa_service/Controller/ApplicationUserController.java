package com.etf.anketa_service.Controller;

import com.etf.anketa_service.Model.ApplicationUser;
import com.etf.anketa_service.Service.ApplicationUserService;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/v1/applicationUser")
@RestController
public class ApplicationUserController {
    private ApplicationUserService applicationUserService;

    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping(path = "/all")
    List<ApplicationUser> getAllUsers() {
        return applicationUserService.getAll();
    }

    @GetMapping
    ApplicationUser getSpecifiedUser(@RequestParam(name = "id", required = true) Long applicationUserId) {
        return applicationUserService.findById(applicationUserId);
    }

    @DeleteMapping(path = "/deleteById")
    ResponseEntity<JSONObject> deleteUser(@RequestParam(name = "id", required = true) Long applicationUserId) throws Exception {
        JSONObject response = new JSONObject();
        try {
            applicationUserService.deleteById(applicationUserId);
            response.put("message", "Uspjesno obrisan korisnik!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception err) {
            response.put("message", err.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
