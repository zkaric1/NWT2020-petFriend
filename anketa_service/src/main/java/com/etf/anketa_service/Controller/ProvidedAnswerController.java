package com.etf.anketa_service.Controller;

import com.etf.anketa_service.DTO.ProvidedAnswerDTO;
import com.etf.anketa_service.Model.ProvidedAnswer;
import com.etf.anketa_service.Service.ProvidedAnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "/v1/providedAnswer")
@RestController
public class ProvidedAnswerController {
    private ProvidedAnswerService providedAnswerService;

    public ProvidedAnswerController(final ProvidedAnswerService providedAnswerService) {
        this.providedAnswerService = providedAnswerService;
    }

    // GET mappings
    @GetMapping("/all")
    public List<ProvidedAnswerDTO> getAllProvidedAnswers() {
        List<ProvidedAnswer> answers = providedAnswerService.fetchAllProvidedAnswers();
        List<ProvidedAnswerDTO> required_answers = new ArrayList<>();
        for(final ProvidedAnswer answer : answers) {
            required_answers.add(new ProvidedAnswerDTO(answer));
        }
        return required_answers;
    }

    @GetMapping
    public ProvidedAnswerDTO getProvidedAnswer(@RequestParam("id") Long providedAnswerId) {
        return new ProvidedAnswerDTO(providedAnswerService.fetchProvidedAnswer(providedAnswerId));
    }

    // DELETE mappings
    @DeleteMapping("/all")
    public void deleteAllProvidedAnswers() {
        providedAnswerService.deleteAllProvidedAnswers();
    }

    @DeleteMapping("/deleteById")
    public void deleteProvidedAnswerById(@RequestParam("id") Long providedAnswerId) {
        providedAnswerService.deleteProvidedAnswerById(providedAnswerId);
    }

    // POST mappings
    @PostMapping
    public ProvidedAnswerDTO addProvidedAnswer(@RequestBody ProvidedAnswerDTO newAnswer) {
        providedAnswerService.addProvidedAnswer(newAnswer.toEntity());
        return newAnswer;
    }

    // PUT mappings
    @PutMapping
    public ProvidedAnswerDTO editProvidedAnswer(@RequestParam("id") Long providedAnswerId, @RequestBody ProvidedAnswerDTO newAnswer) {
        providedAnswerService.editProvidedAnswer(providedAnswerId, newAnswer.toEntity());
        return newAnswer;
    }
}
