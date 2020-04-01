package com.example.zivotinja.controller;

import com.example.zivotinja.model.Bolest;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import com.example.zivotinja.service.BolestService;

import javax.validation.Valid;

@RestController
public class BolestController {

    private BolestService bolestService;

    BolestController(BolestService bolestService) {
        this.bolestService = bolestService;
    }

    // Bez Hateoas
    @GetMapping("/bolest")
    List<Bolest> dobaviBolestIme(@RequestParam(value = "ime", required = false) String ime) throws Exception {
        if (ime != null) return bolestService.findByName(ime);
        else return bolestService.findAll();
    }

    // Sa Hateoas
    @GetMapping("/bolesti")
    public CollectionModel<EntityModel<Bolest>> all() {
        return bolestService.findAllHateoas();
    }

    @GetMapping("/bolesti/{id}")
    public Bolest one(@PathVariable Long id) {
        return bolestService.findById(id);
        // return assembler.toModel(bolest);
    }

    // DELETE metode
    @DeleteMapping("/bolesti")
    void izbrisiSveBolesti(@RequestParam(value = "ime", required = false) String ime) throws Exception {
        if (ime != null) bolestService.deleteByName(ime);
        else bolestService.deleteAll();
    }

    @DeleteMapping("bolesti/{id}")
    void izbrisiBolest(@PathVariable Long id) throws Exception {
        bolestService.deleteById(id);
    }

    // PUT metode
    @PutMapping("/bolesti/{id}")
    Bolest updateBolest(@RequestBody Bolest novaBolest, @PathVariable Long id) throws Exception {
        return bolestService.put(novaBolest, id);
    }

    // POST metode
    @PostMapping("/bolesti")
    Bolest novaBolest(@Valid @RequestBody Bolest nBol) {
        return bolestService.post(nBol);
    }
}

