package com.etf.korisnik_service;

import com.etf.korisnik_service.model.*;
import com.etf.korisnik_service.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KorisnikServiceApplication {
    private static final Logger log =
            LoggerFactory.getLogger(KorisnikServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KorisnikServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner proba(KorisnikInterface kRepository, ZivotinjaInterface zRepository, UlogaInterface uRepository, KorisnikZivotinjaInterface kzRepository) {
        return (args) -> {
            //uloge
            uRepository.save(new Uloga("administrator"));
            Uloga u = uRepository.save(new Uloga("korisnik"));
            uRepository.save(new Uloga("veterinar"));
            log.info("Sve uloge \n");
            for (Uloga uloga : uRepository.findAll()) {
                log.info(uloga.getNazivUloge());
            }
            log.info(" ");

            // korisnici
            Korisnik k1 = kRepository.save(new Korisnik("ante antic","1234567899876",u));
            k1.setUlogaId(u);
            Korisnik k2 = kRepository.save(new Korisnik("amno amnic","93832979237937",u));
            kRepository.save(new Korisnik("zlata karic","34324343434",u));
            log.info("Svi korisnici \n");
            for (Korisnik korisnik : kRepository.findAll()) {
                log.info(korisnik.getImePrezime());
            }

            log.info(" ");

            //zivotinje
            Zivotinja z1 = zRepository.save(new Zivotinja("macka", "Z"));
            Zivotinja z2 = zRepository.save(new Zivotinja("pas", "M"));
            log.info("Sve zivotinje \n");
            for (Zivotinja zivotinja : zRepository.findAll()) {
                log.info(zivotinja.toString());
            }
            log.info(" ");

            //korisnik - zivotinja
            kzRepository.save(new KorisnikZivotinja(k1,z1));
            kzRepository.save(new KorisnikZivotinja(k2,z2));
            log.info("Sve korisnik-zivotinja \n");
            for (KorisnikZivotinja korisnikZivotinja : kzRepository.findAll()) {
                log.info(korisnikZivotinja.toString());
            }

        };
    }

}
