## Preduslovi za pokretanje projekta
Da bi se projekt uspješno pokrenuo potrebno je imati `Javu 11` verziju `11.0.2`. Baza koja se trenutno koristi je `H2 Database Engine`. Postavke za bazu za mikroservis `Korisnik`:
```
server.port=8082
spring.application.name=korisnikService
spring.datasource.url=jdbc:h2:~/testbaza
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=admin
spring.datasource.password=password1
spring.h2.console.enabled=true
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka

```
Konfiguracija za `Eureka`:
```
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
logging.level.com.netflix.eureka=OFF
logging.level.com.netflix.discovery=OFF
```

Svi mikroservisi i Eureka moraju biti pokrenuti u isto vrijeme da bi se mogla ostvariti komunikacija.

## Pokretanje projekta
Da bi se projekat uspješno pokrenuo, u root direktorij mikroservisa potrebno je unijeti komandu mvn `spring-boot:run`

## Pokretanje testova
Da bi se testovi uspješno pokrenuli, potrebno se navigirati u root direktorij testova (folder test) i unijeti komandu mvn test `-Dtest=ime fajla sa testovima (npr. mvn test -Dtest=UserControllerTest)`

## Pristupanje swaggeru
 Swagger na sljedećem linku: http://localhost:8082/swagger-ui.html
 Pomocu Swaggera mozete vidjeti i pokrenuti sve API-je sto se nalaze u ovom mikroservisu.


