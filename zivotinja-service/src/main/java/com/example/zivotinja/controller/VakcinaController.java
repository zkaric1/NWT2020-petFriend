package com.example.zivotinja.controller;
import com.example.zivotinja.model.Vakcina;
import com.example.zivotinja.exception.VakcinaException;
import com.example.zivotinja.repository.VakcinaRepository;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class VakcinaController {

    private VakcinaRepository vakcinaRepository;
    public VakcinaController (VakcinaRepository repo) {
        vakcinaRepository = repo;
    }

    // GET metode
    @GetMapping ("/vakcine")
    List<Vakcina> dobaviVakcineTip(@RequestParam(value = "tip", required = false) String tip) throws Exception {
        if (tip != null) {
            if (vakcinaRepository.findByType(tip).size() == 0) {
                throw new Exception("Ne postoji vakcina za bolest " + tip);
            }
            return vakcinaRepository.findByType(tip);
        }
        else {
            return vakcinaRepository.findAll();
        }
    }

    @GetMapping ("/vakcine/{id}")
    public Vakcina one (@PathVariable Long id) {
        return vakcinaRepository.findById(id).orElseThrow(() -> new VakcinaException(id));
    }

    // DELETE metode
    @DeleteMapping ("/vakcine")
    void izbrisiSveVakcine(@RequestParam(value = "tip", required = false) String tip) throws Exception {
        if (vakcinaRepository.count() == 0) {
            throw new Exception("Ne postoji vise vakcina u bazi podataka");
        }
        if (tip != null) {
            vakcinaRepository.deleteByType(tip);
        }
        else {
            vakcinaRepository.deleteAll();
        }
    }

    @DeleteMapping ("vakcine/{id}")
    void izbrisiVakcinu (@PathVariable Long id) throws Exception {
        if (!vakcinaRepository.existsById(id)) {
            throw new Exception("Ne postoji vakcina sa id " + id);
        }
        vakcinaRepository.deleteById(id);
    }

    // PUT metode
    @PutMapping("/vakcine/{id}")
    Vakcina updateVakcina(@RequestBody Vakcina novaVakcina, @PathVariable Long id) throws Exception {
        if (!vakcinaRepository.existsById(id)) {
            throw new Exception ("Ne postoji vakcina sa trazenim id " + id);
        }
        return vakcinaRepository.findById(id)
                .map(vakcina -> {
                    vakcina.setRevakcinacija(novaVakcina.getRevakcinacija());
                    vakcina.setTip(novaVakcina.getTip());
                    return vakcinaRepository.save(vakcina);
                })
                .orElseGet(() -> {
                    novaVakcina.setId(id);
                    return vakcinaRepository.save(novaVakcina);
                });
    }

    // POST metode
    @PostMapping ("/vakcine")
    Vakcina novaVakcina (@Valid @RequestBody Vakcina nVak) {
        return vakcinaRepository.save(nVak);
    }
}
