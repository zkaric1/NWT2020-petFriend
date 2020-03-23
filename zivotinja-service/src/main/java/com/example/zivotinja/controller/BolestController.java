package com.example.zivotinja.controller;
import com.example.zivotinja.model.Bolest;
import com.example.zivotinja.model.BolestException;
import org.springframework.web.bind.annotation.*;
import com.example.zivotinja.repository.BolestRepository;
import java.util.List;

@RestController
public class BolestController {

    private BolestRepository bolestRepository;
    BolestController (BolestRepository repo) {
        bolestRepository = repo;
    }

    @RequestMapping("/bolesti")
    List<Bolest> dobaviBolestIme(@RequestParam(value = "ime", required = false) String ime) {
        if (ime != null) {
            return bolestRepository.findByName(ime);
        }
        else {
            return bolestRepository.findAll();
        }
    }

    @RequestMapping ("/bolesti/{id}")
    public Bolest one (@PathVariable Long id) {
        return bolestRepository.findById(id).orElseThrow(() -> new BolestException(id));
    }

    // DELETE metode
    @DeleteMapping("/bolesti")
    void izbrisiSveBolesti(@RequestParam(value = "ime", required = false) String ime) {
        if (ime != null) {
            bolestRepository.deleteByName(ime);
        }
        else {
            bolestRepository.deleteAll();
        }
    }

    @DeleteMapping ("bolesti/{id}")
    void izbrisiBolest (@PathVariable Long id) {
        bolestRepository.deleteById(id);
    }

    // PUT metode
    @PutMapping("/bolesti/{id}")
    Bolest updateBolest(@RequestBody Bolest novaBolest, @PathVariable Long id) {
        return bolestRepository.findById(id)
                .map(bolest -> {
                    bolest.setIme(novaBolest.getIme());
                    bolest.setLijek(novaBolest.getLijek());
                    return bolestRepository.save(bolest);
                })
                .orElseGet(() -> {
                    novaBolest.setId(id);
                    return bolestRepository.save(novaBolest);
                });
    }

    // POST metode
    @PostMapping ("/bolesti")
    Bolest novaBolest (@RequestBody Bolest nBol) {
        return bolestRepository.save(nBol);
    }
}

