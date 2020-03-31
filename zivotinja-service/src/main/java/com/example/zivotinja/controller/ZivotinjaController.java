package com.example.zivotinja.controller;
import com.example.zivotinja.model.Zivotinja;
import com.example.zivotinja.service.ZivotinjaService;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class ZivotinjaController {

    private ZivotinjaService zivotinjaService;

    ZivotinjaController(ZivotinjaService zivotinjaService) {
        this.zivotinjaService = zivotinjaService;
    }

    // GET metode

    @GetMapping("/zivotinje/{id}")
    public Zivotinja one(@PathVariable Long id) throws Exception {
        return zivotinjaService.findById(id);
    }

    @GetMapping("zivotinje/{id}/godine")
    public Map<String, Integer> vratiGodine(@PathVariable Long id) throws Exception {
        return zivotinjaService.getGodine(id);
    }

    @GetMapping("/zivotinje")
    public List<Zivotinja> dobaviZivotinjaIme(@RequestParam(value = "ime", required = false) String ime) throws Exception {
        if (ime != null) return zivotinjaService.findByName(ime);
        else return zivotinjaService.findAll();
    }

    // DELETE metode
    @DeleteMapping("/zivotinje")
    void izbrisiSveZivotinje(@RequestParam(value = "ime", required = false) String ime) throws Exception {
        if (ime != null) zivotinjaService.deleteByName(ime);
        else zivotinjaService.deleteAll();
    }

    @DeleteMapping("/zivotinje/{id}")
    void izbrisiZivotinju(@PathVariable Long id) throws Exception {
        zivotinjaService.deleteById(id);
    }

    // PUT metode
    @PutMapping("/zivotinje/{id}")
    Zivotinja updateZivotinje(@RequestBody Zivotinja novaZivotinja, @PathVariable Long id) throws Exception {
        return zivotinjaService.put(novaZivotinja, id);
    }

    // POST metode
    @PostMapping("/zivotinje")
    Zivotinja novaZivotinja(@Valid @RequestBody Zivotinja nZivotinja) {
        return zivotinjaService.post(nZivotinja);
    }
}
