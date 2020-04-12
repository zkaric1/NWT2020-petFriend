package com.etf.korisnik_service;

import com.etf.korisnik_service.model.*;
import com.etf.korisnik_service.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class UserServiceApplication {
    private static final Logger log =
            LoggerFactory.getLogger(UserServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner proba(UserRepository kRepository, AnimalRepository zRepository, RoleRepository uRepository, UserAnimalRepository kzRepository) {
        return (args) -> {
            //uloge
            uRepository.save(new Role("administrator"));
            Role u = uRepository.save(new Role("korisnik"));
            uRepository.save(new Role("veterinar"));
            log.info("Sve uloge \n");
            for (Role role : uRepository.findAll()) {
                log.info(role.getRoleName());
            }
            log.info(" ");

            // korisnici
            User k1 = kRepository.save(new User("ante antic", "1234567899876", u));
            k1.setRole(u);
            User k2 = kRepository.save(new User("amno amnic", "93832979237937", u));
            kRepository.save(new User("zlata karic", "34324343434", u));
            kRepository.save(new User("marko marulic", "323343432342424", u));
            log.info("Svi korisnici \n");
            for (User user : kRepository.findAll()) {
                log.info(user.getFullName());
            }

            log.info(" ");

            //zivotinje
            Animal z1 = zRepository.save(new Animal("macka", "Z"));
            Animal z2 = zRepository.save(new Animal("pas", "M"));
            log.info("Sve zivotinje \n");
            for (Animal animal : zRepository.findAll()) {
                log.info(animal.toString());
            }
            log.info(" ");

            //korisnik - zivotinja
            kzRepository.save(new UserAnimal(k1, z1));
            kzRepository.save(new UserAnimal(k1,z2));
            kzRepository.save(new UserAnimal(k2, z2));
            log.info("Sve korisnik-zivotinja \n");
            for (UserAnimal userAnimal : kzRepository.findAll()) {
                log.info(userAnimal.toString());
            }

        };
    }

}
