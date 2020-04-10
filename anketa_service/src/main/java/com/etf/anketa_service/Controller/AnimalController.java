package com.etf.anketa_service.Controller;

import com.etf.anketa_service.DTO.AnimalDTO;
import com.etf.anketa_service.Model.Animal;
import com.etf.anketa_service.Service.AnimalService;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(path = "/v1/animal")
@RestController
public class AnimalController {
    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping(path = "/all")
    List<Animal> getAllAnimals() {
        return animalService.getAll();
    }

    @GetMapping
    Animal getSpecifiedAnimal(@RequestParam(name = "id", required = true) Long animalId) {
        return animalService.findById(animalId);
    }

    @DeleteMapping(path = "/deleteById")
    ResponseEntity<JSONObject> deleteAnimal(@RequestParam(name = "id", required = true) Long animalId) throws Exception {
        JSONObject response = new JSONObject();
        try {
            animalService.deleteById(animalId);
            response.put("message", "Uspjesno obrisana zivotinja!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception err) {
            response.put("message", err.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
