package com.example.zivotinja;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import com.example.zivotinja.repository.*;
import com.example.zivotinja.model.*;


@SpringBootApplication
public class ZivotinjaServiceApplication {
    private static final Logger log = LoggerFactory.getLogger(ZivotinjaServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZivotinjaServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ZivotinjaRepository zRepo, BolestRepository bRepo, KorisnikRepository kRepo, VakcinaRepository vRepo, VeterinarRepository vetRepo) {
        return (args) -> {

            // Kreiranje bolesti
            bRepo.save(new Bolest("Bjesnilo", "Antibiotici"));
            bRepo.save(new Bolest("Gripa", "Tablete"));
            bRepo.save(new Bolest("Prehlada", "Injekcija"));

            // Provjera da li je uspjesno kreirano
            log.info("Sve bolesti: ");
            for (Bolest b : bRepo.findAll()) {
                log.info(b.getIme().toString());
            }

            // Kreiranje veterinara
            vetRepo.save(new Veterinar("Abdulah", "Jakupovic", "061546954", "Stjepana Radica 18/15"));
            vetRepo.save(new Veterinar("Ivan", "Simic", "062569412", "Hamdije Cemerlica 1"));
            vetRepo.save(new Veterinar("Amila", "Perenda", "066879145", "Paromlinska 52"));

            // Kreiranje vakcine
            vRepo.save(new Vakcina("Hepatits", 12));
            vRepo.save(new Vakcina("Stenecak", 24));
            vRepo.save(new Vakcina("DHPP", 6));


            // Kreiranje zivotinje
            Zivotinja cuko = new Zivotinja("Mini", "Pas", "Labrador", "Z", 2, "Mali pas", 10, "Spremna za Vas dom!", false);
            byte[] slika = cuko.kreirajSliku("C:\\Users\\belma\\Desktop\\NWT2020-petFriend\\zivotinja-service\\Slike\\viki.jpg");
            cuko.setSlika(slika);
            zRepo.save(cuko);
            cuko.preuzmiSliku();

            zRepo.save(new Zivotinja("Viki", "Pas", "Labrador", "Z", 2, "Mali pas", 10, "Preslatki mali cuko", false));

        };
    }
}
