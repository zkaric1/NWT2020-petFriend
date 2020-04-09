package com.etf.anketa_service.Controller;

import com.etf.anketa_service.DTO.AnimalDTO;
import com.etf.anketa_service.Model.Animal;
import com.etf.anketa_service.Service.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    List<AnimalDTO> getAllAnimals() {
        List<Animal> animals = animalService.getAll();
        return animals.stream().map(AnimalDTO::new).collect(Collectors.toList());
    }
}
