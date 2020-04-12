## Preduslovi za pokretanje projekta
Da bi se projekt uspješno pokrenuo potrebno je imati instaliranu verziju `Java 1.8`. Baza koja se trenutno koristi je `H2 Database Engine`. Postavke za bazu su sljedeće.
```
server.port=<server>
spring.application.name=<ime mikro servisa>
spring.h2.console.enabled=true
spring.datasource.username=<username za bazu>
spring.datasource.password=<password za bazu>
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka

```
Da bi se svi mikroservisi uspješno povezali, potrebno je konfigurisati `Eureka` lokalno.
```
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
logging.level.com.netflix.eureka=OFF
logging.level.com.netflix.discovery=OFF
```

Svi mikroservisi i Eureka moraju biti pokrenuti u isto vrijeme da bi se mogla ostvariti komunikacija.

## Pokretanje projekta
Da bi se projekat uspješno pokrenuo, potrebno se navigirati u root direktorij (folder Model) i unijeti komandu mvn `spring-boot:run`

## Pokretanje testova
Da bi se testovi uspješno pokrenuli, potrebno se navigirati u root direktorij testova (folder test) i unijeti komandu mvn test `-Dtest=ime fajla sa testovima (npr. mvn test -Dtest=BolestControllerTest)`

## Pristupanje swaggeru
Nakon što se projekat pokrene, omogućen je pregleda svih API servisa pomoću Swagger-a na sljedećem linku: http://localhost:8080/swagger-ui.html

