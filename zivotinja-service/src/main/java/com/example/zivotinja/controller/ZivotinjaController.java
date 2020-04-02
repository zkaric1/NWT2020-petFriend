package com.example.zivotinja.controller;
import com.example.zivotinja.model.Zivotinja;
import com.example.zivotinja.service.ZivotinjaService;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<JSONObject> izbrisiSveZivotinje(@RequestParam(value = "ime", required = false) String ime) throws Exception {
        JSONObject temp = new JSONObject();
        try {
            if (ime != null) {
                zivotinjaService.deleteByName(ime);
                temp.put("message", "Uspjesno obrisana zivotinja sa imenom: " + ime);
                return new ResponseEntity<>(
                        temp,
                        HttpStatus.OK
                );
            }
            else {
                zivotinjaService.deleteAll();
                temp.put("message", "Uspjesno obrisane sve zivotinje!");
                return new ResponseEntity<>(
                        temp,
                        HttpStatus.OK
                );
            }
        }
        catch (Exception e) {
            temp.put("message", "Greska pri brisanju zivotinja/e!");
            return new ResponseEntity<>(
                    temp,
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @DeleteMapping("/zivotinje/{id}")
    ResponseEntity<JSONObject> izbrisiZivotinju(@PathVariable Long id) throws Exception {
        JSONObject temp = new JSONObject();
        try {
            zivotinjaService.deleteById(id);
            temp.put("message", "Uspjesno obrisana zivotinja sa id " + id);
            return new ResponseEntity<>(
                    temp,
                    HttpStatus.OK
            );
        }
        catch (Exception e) {
            temp.put("message", "Greska pri brisanju zivotinje sa id " + id);
            return new ResponseEntity<>(
                    temp,
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    // PUT metode
    @PutMapping("/zivotinje/{id}")
    ResponseEntity<JSONObject> updateZivotinje(@RequestBody Zivotinja novaZivotinja, @PathVariable Long id) throws Exception {
        JSONObject temp = new JSONObject();
        try {
            zivotinjaService.put(novaZivotinja, id);
            temp.put("message", "Uspjesno azurirana zivotinja sa id " + id);
            return new ResponseEntity<>(
                    temp,
                    HttpStatus.OK
            );
        }
        catch (Exception e) {
            temp.put("message", "Greska pri azuriranju zivotinje sa id " + id);
            return new ResponseEntity<>(
                    temp,
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    // POST metode
    @PostMapping("/zivotinje")
    Zivotinja novaZivotinja(@Valid @RequestBody Zivotinja nZivotinja) {
        return zivotinjaService.post(nZivotinja);
    }
}
