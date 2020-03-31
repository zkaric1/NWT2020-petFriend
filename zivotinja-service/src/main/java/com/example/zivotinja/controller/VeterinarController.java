package com.example.zivotinja.controller;
import com.example.zivotinja.model.Veterinar;
import com.example.zivotinja.exception.VeterinarException;
import com.example.zivotinja.repository.VeterinarRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VeterinarController {

    private VeterinarRepository veterinarRepository;
    VeterinarController(VeterinarRepository repo) {
        veterinarRepository = repo;
    }

    // GET metode
    @GetMapping ("/veterinari")
    public List<Veterinar> dobaviVeterinareIme (@RequestParam(value = "ime", required = false) String ime) throws Exception {
        if (ime != null) {
            if (veterinarRepository.findByName(ime).size() == 0) {
                throw new Exception ("Ne postoji veterinar sa imenom " + ime);
            }
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

    // DELETE metode
    @DeleteMapping ("/veterinari")
    void izbrisiSveVeterinare(@RequestParam(value = "ime", required = false) String ime) throws Exception{
        if (veterinarRepository.count() == 0) {
            throw new Exception ("Ne postoji vise veterinara u bazi podataka!");
        }
        if (ime != null) veterinarRepository.deleteByName(ime);
        else veterinarRepository.deleteAll();
    }

    @DeleteMapping("/veterinari/{id}")
    void izbrisiVeterinara(@PathVariable Long id) throws Exception {
        if (!veterinarRepository.existsById(id)) {
            throw new Exception("Ne postoji veterinar sa id " + id);
        }
        veterinarRepository.deleteById(id);
    }

    // PUT metode
    @PutMapping("/veterinari/{id}")
    Veterinar updateVeterinar(@RequestBody Veterinar noviVeterinar, @PathVariable Long id) throws Exception {
        if (!veterinarRepository.existsById(id)) {
            throw new Exception("Ne postoji veterinar sa id " + id);
        }
        return veterinarRepository.findById(id)
                .map(veterinar -> {
                    veterinar.setAdresa(noviVeterinar.getAdresa());
                    veterinar.setIme(noviVeterinar.getIme());
                    veterinar.setKontaktTelefon(noviVeterinar.getKontaktTelefon());
                    veterinar.setPrezime(noviVeterinar.getPrezime());
                    return veterinarRepository.save(veterinar);
                })
                .orElseGet(() -> {
                    noviVeterinar.setId(id);
                    return veterinarRepository.save(noviVeterinar);
                });
    }

    // POST metode
    @PostMapping ("/veterinari")
    Veterinar noviVeterinar (@Valid  @RequestBody Veterinar nVet) {
        return veterinarRepository.save(nVet);
    }
}
