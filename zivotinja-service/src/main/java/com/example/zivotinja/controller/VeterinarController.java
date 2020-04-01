package com.example.zivotinja.controller;

import com.example.zivotinja.model.Veterinar;
import com.example.zivotinja.service.VeterinarService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VeterinarController {

    private VeterinarService veterinarService;

    VeterinarController(VeterinarService veterinarService) {
        this.veterinarService = veterinarService;
    }

    // GET metode
    @GetMapping("/veterinari")
    public List<Veterinar> dobaviVeterinareIme(@RequestParam(value = "ime", required = false) String ime) throws Exception {
        if (ime != null) return veterinarService.findByName(ime);
        else return veterinarService.findAll();
    }

    @GetMapping("/veterinari/{id}")
    public Veterinar one(@PathVariable Long id) throws Exception {
        return veterinarService.findById(id);
    }

    // DELETE metode
    @DeleteMapping("/veterinari")
    void izbrisiSveVeterinare(@RequestParam(value = "ime", required = false) String ime) throws Exception {
        if (ime != null) veterinarService.deleteByName(ime);
        else veterinarService.deleteAll();
    }

    @DeleteMapping("/veterinari/{id}")
    void izbrisiVeterinara(@PathVariable Long id) throws Exception {
        veterinarService.deleteById(id);
    }

    // PUT metode
    @PutMapping("/veterinari/{id}")
    Veterinar updateVeterinar(@RequestBody Veterinar noviVeterinar, @PathVariable Long id) throws Exception {
        return veterinarService.put(noviVeterinar, id);
    }

    // POST metode
    @PostMapping("/veterinari")
    Veterinar noviVeterinar(@Valid @RequestBody Veterinar nVet) {
        return veterinarService.post(nVet);
    }
}
