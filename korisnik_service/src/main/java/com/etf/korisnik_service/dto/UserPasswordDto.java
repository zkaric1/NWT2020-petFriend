package com.etf.korisnik_service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserPasswordDto {
    @NotNull
    @NotBlank
    String newPassword;

    public UserPasswordDto(@NotNull @NotBlank String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String password) {
        this.newPassword = password;
    }
}
