package com.example.zivotinja.controller;
import com.example.zivotinja.assembler.BolestModelAssembler;
import com.example.zivotinja.model.Bolest;
import com.example.zivotinja.exception.BolestException;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import com.example.zivotinja.repository.BolestRepository;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;

import javax.validation.Valid;

@RestController
public class BolestController {

    private BolestRepository bolestRepository;
    private final BolestModelAssembler assembler;

    BolestController(BolestRepository repo, BolestModelAssembler assembler) {
        bolestRepository = repo;
        this.assembler = assembler;
    }

    // Bez Hateoas
    @GetMapping("/bolest")
    List<Bolest> dobaviBolestIme(@RequestParam(value = "ime", required = false) String ime) throws Exception{
        if (ime != null) {
            if (bolestRepository.findByName(ime).size() == 0) {
                throw new Exception("Ne postoji bolest sa trazenim imenom " + ime);
            }
            return bolestRepository.findByName(ime);
        }
        else {
            return bolestRepository.findAll();
        }
    }

    // Sa Hateoas
    @GetMapping("/bolesti")
    public CollectionModel<EntityModel<Bolest>> all() {
        List<EntityModel<Bolest>> employees = bolestRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return new CollectionModel<>(employees,
                linkTo(methodOn(BolestController.class).all()).withSelfRel());
    }

    @GetMapping("/bolesti/{id}")
    public EntityModel<Bolest> one(@PathVariable Long id) {
        Bolest bolest = bolestRepository.findById(id).orElseThrow(() -> new BolestException(id));
        return assembler.toModel(bolest);
    }

    // DELETE metode
    @DeleteMapping("/bolesti")
    void izbrisiSveBolesti(@RequestParam(value = "ime", required = false) String ime) throws Exception{
        if (bolestRepository.count() == 0) {
            throw new Exception("Ne postoji vise bolesti u bazi podataka");
        }
        if (ime != null) {
            bolestRepository.deleteByName(ime);
        }
        else {
            bolestRepository.deleteAll();
        }
    }

    @DeleteMapping ("bolesti/{id}")
    void izbrisiBolest (@PathVariable Long id) throws Exception {
        if (!bolestRepository.existsById(id)) {
            throw new Exception("Ne postoji bolest sa id " + id);
        }
        bolestRepository.deleteById(id);
    }

    // PUT metode
    @PutMapping("/bolesti/{id}")
    Bolest updateBolest(@RequestBody Bolest novaBolest, @PathVariable Long id) throws Exception{
        if (!bolestRepository.existsById(id)) {
            throw new Exception ("Ne postoji bolest sa trazenim id " + id);
        }
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
    Bolest novaBolest (@Valid @RequestBody Bolest nBol) {
        return bolestRepository.save(nBol);
    }
}

