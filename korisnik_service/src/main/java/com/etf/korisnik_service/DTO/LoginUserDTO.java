package com.etf.korisnik_service.DTO;

import javax.validation.constraints.Pattern;

public class LoginUserDTO {

    @Pattern(regexp = "^(.+)@(.+)$", message = "Email nije dobrog formata")
    String email;
    @Pattern(regexp = "[\\w\\d]{7,}", message = "Sifra mora imati minimalno 7 znakova (karaktera ili brojeva)")
    String password;

    public LoginUserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
