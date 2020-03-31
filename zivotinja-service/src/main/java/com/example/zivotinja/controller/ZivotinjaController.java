package com.example.zivotinja.controller;
import com.example.zivotinja.ZivotinjaServiceApplication;
import com.example.zivotinja.model.Zivotinja;
import com.example.zivotinja.exception.ZivotinjaException;
import com.example.zivotinja.repository.ZivotinjaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ZivotinjaController {
    private ZivotinjaRepository zivotinjaRepository;
    private static final Logger log = LoggerFactory.getLogger(ZivotinjaServiceApplication.class);

    ZivotinjaController(ZivotinjaRepository repo) {
        zivotinjaRepository = repo;
    }

    // GET metode

    @GetMapping("/zivotinje/{id}")
    public Zivotinja one(@PathVariable Long id) {
        return zivotinjaRepository.findById(id).orElseThrow(() -> new ZivotinjaException(id));
    }

    @GetMapping("zivotinje/{id}/godine")
    public Map<String, Integer> vratiGodine(@PathVariable Long id) throws Exception{
        if (!zivotinjaRepository.existsById(id)) {
            throw new Exception("Ne postoji zivotinja sa id " + id);
        }
        List<Zivotinja> ziv = zivotinjaRepository.findByAge(id);
        HashMap<String, Integer> mapa = new HashMap<>();
        int godine = 0;
        for (Zivotinja ob : ziv){
            godine = ob.getGodine();
        }
        mapa.put("godine", godine);
        return mapa;
    }

    @GetMapping("/zivotinje")
    public List<Zivotinja> dobaviZivotinjaIme(@RequestParam(value = "ime", required = false) String ime) throws Exception{
        if (ime != null) {
            if (zivotinjaRepository.findByName(ime).size() == 0) {
                throw new Exception("Ne postoji zivotinja sa imenom " + ime);
            }
            return zivotinjaRepository.findByName(ime);
        } else {
            return zivotinjaRepository.findAll();
        }
    }

    // DELETE metode
    @DeleteMapping("/zivotinje")
    void izbrisiSveZivotinje(@RequestParam(value = "ime", required = false) String ime) throws Exception {
        if (zivotinjaRepository.count() == 0) {
            throw new Exception ("Baza ne sadrzi niti jednu zivotinju!");
        }
        if (ime != null) zivotinjaRepository.deleteByName(ime);
        else zivotinjaRepository.deleteAll();
    }

    @DeleteMapping("/zivotinje/{id}")
    void izbrisiZivotinju(@PathVariable Long id) throws Exception {
        if(!zivotinjaRepository.existsById(id)) {
            throw new Exception ("Ne postoji zivotinja sa id " + id);
        }
        zivotinjaRepository.deleteById(id);
    }

    // PUT metode
    @PutMapping("/zivotinje/{id}")
    Zivotinja updateZivotinje(@RequestBody Zivotinja novaZivotinja, @PathVariable Long id) throws Exception {
        if (!zivotinjaRepository.existsById(id)) {
            throw new Exception ("Zivotinja sa id " + id + " ne postoji u bazi!");
        }
        return zivotinjaRepository.findById(id)
                .map(zivotinja -> {
                    zivotinja.setSlika(novaZivotinja.getSlika());
                    zivotinja.setDodatniOpis(novaZivotinja.getDodatniOpis());
                    zivotinja.setGodine(novaZivotinja.getGodine());
                    zivotinja.setIme(novaZivotinja.getIme());
                    zivotinja.setRasa(novaZivotinja.getRasa());
                    zivotinja.setSpol(novaZivotinja.getSpol());
                    zivotinja.setTezina(novaZivotinja.getTezina());
                    zivotinja.setUdomljena(novaZivotinja.isUdomljena());
                    zivotinja.setVelicina(novaZivotinja.getVelicina());
                    zivotinja.setVrsta(novaZivotinja.getVrsta());
                    return zivotinjaRepository.save(zivotinja);
                })
                .orElseGet(() -> {
                    novaZivotinja.setId(id);
                    return zivotinjaRepository.save(novaZivotinja);
                });
    }

    // POST metode
    @PostMapping ("/zivotinje")
    Zivotinja novaZivotinja (@Valid @RequestBody Zivotinja nZivotinja) {
        return zivotinjaRepository.save(nZivotinja);
    }
}
