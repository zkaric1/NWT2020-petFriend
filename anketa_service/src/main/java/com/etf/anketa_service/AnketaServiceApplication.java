package com.etf.anketa_service;

import com.etf.anketa_service.Model.Question;
import com.etf.anketa_service.Repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnketaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnketaServiceApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner demo(QuestionRepository questionRepository) {
        return (args) -> {
            questionRepository.save(new Question("Koliko ljubimaca imate?", true, null));
        };
    }*/
}
