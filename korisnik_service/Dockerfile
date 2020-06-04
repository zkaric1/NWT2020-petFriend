FROM openjdk:11
ADD testbaza.mv.db  /testbaza.mv.db
ADD target/korisnik_service.jar korisnik_service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","korisnik_service.jar"]