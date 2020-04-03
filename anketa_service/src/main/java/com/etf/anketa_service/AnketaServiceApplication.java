package com.etf.anketa_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
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
