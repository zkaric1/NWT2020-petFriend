package com.etf.anketa_service.Service;

import com.etf.anketa_service.Exception.ProvidedAnswerException;
import com.etf.anketa_service.Exception.QuestionException;
import com.etf.anketa_service.Model.ProvidedAnswer;
import com.etf.anketa_service.Repository.ProvidedAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvidedAnswerService {
    private ProvidedAnswerRepository providedAnswerRepository;

    public ProvidedAnswerService(final ProvidedAnswerRepository providedAnswerRepository) {
        this.providedAnswerRepository = providedAnswerRepository;
    }

    public List<ProvidedAnswer> fetchAllProvidedAnswers() {
        return providedAnswerRepository.findAll();
    }

    public ProvidedAnswer fetchProvidedAnswer(Long providedAnswerId) {
        ProvidedAnswer answer = (providedAnswerRepository.findById(providedAnswerId).isPresent()) ? providedAnswerRepository.findById(providedAnswerId).get() : null;
        if(answer == null) {
            throw new ProvidedAnswerException();
        }
        return answer;
    }

    public void deleteAllProvidedAnswers() {
        providedAnswerRepository.deleteAll();
    }

    public void deleteProvidedAnswerById(Long providedAnswerId) {
        providedAnswerRepository.deleteById(providedAnswerId);
    }

    public void addProvidedAnswer(final ProvidedAnswer answer) {
        providedAnswerRepository.save(answer);
    }

    public void editProvidedAnswer(Long id, ProvidedAnswer answer) {
        ProvidedAnswer toEdit = (providedAnswerRepository.findById(id).isPresent()) ? providedAnswerRepository.findById(id).get() : null;
        if(toEdit == null) {
            throw new QuestionException();
        }
        else {
            toEdit.setAnswerText(answer.getAnswerText());
            toEdit.setSurveyQuestionAnswers(answer.getSurveyQuestionAnswers());
            providedAnswerRepository.save(answer);
        }
    }
}
