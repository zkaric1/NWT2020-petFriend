package com.example.zivotinja.controller;
import com.example.zivotinja.model.Veterinar;
import com.example.zivotinja.model.VeterinarException;
import com.example.zivotinja.model.Zivotinja;
import com.example.zivotinja.model.ZivotinjaException;
import com.example.zivotinja.repository.VeterinarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VeterinarController {

    private VeterinarRepository veterinarRepository;
    VeterinarController(VeterinarRepository repo) {
        veterinarRepository = repo;
    }

    // GET metode
    @GetMapping ("/veterinari")
    public List<Veterinar> dobaviVeterinareIme (@RequestParam(value = "ime", required = false) String ime) {
        if (ime != null) {
            return veterinarRepository.findByName(ime);
        }
        else {
            return veterinarRepository.findAll();
        }
    }

    @GetMapping ("/veterinari/{id}")
    public Veterinar one(@PathVariable Long id) {
        return veterinarRepository.findById(id).orElseThrow(() -> new VeterinarException(id));
    }

}
