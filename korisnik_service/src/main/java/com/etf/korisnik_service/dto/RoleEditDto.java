package com.etf.korisnik_service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RoleEditDto {
    @NotNull
    @NotBlank
    String newRoleName;

    public RoleEditDto(@NotNull @NotBlank String newRoleName) {
        this.newRoleName = newRoleName;
    }

    public String getNewRoleName() {
        return newRoleName;
    }

    public void setNewRoleName(String newRoleName) {
        this.newRoleName = newRoleName;
    }
}
