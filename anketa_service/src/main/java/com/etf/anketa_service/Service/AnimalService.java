package com.etf.anketa_service.Service;

import com.etf.anketa_service.Exception.AnimalException;
import com.etf.anketa_service.Model.Animal;
import com.etf.anketa_service.Repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new AnimalException(id));
    }

    public void deleteById(Long id) throws Exception {
        animalRepository.deleteById(id);
    }
}
