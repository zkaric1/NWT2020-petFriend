package com.etf.korisnik_service.dto;

import com.etf.korisnik_service.model.User;
import org.modelmapper.ModelMapper;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserPasswordDto {
    @NotNull
    @Id
    Integer id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "[\\w\\d]{7,}", message = "Sifra mora imati minimalno 7 znakova (karaktera ili brojeva)")
    String password;

    public UserPasswordDto(@NotNull Integer id, @NotNull @NotBlank String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User convertToEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this,User.class);
    }
}
