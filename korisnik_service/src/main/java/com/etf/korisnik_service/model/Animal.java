package com.etf.korisnik_service.model;

import javax.persistence.*;

@Entity
@Table(name = "Animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String species;
    private String gender;

    public Animal() {
    }

    public Animal(String species, String gender) {
        this.species = species;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String vrsta) {
        this.species = vrsta;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String spol) {
        this.gender = spol;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", species='" + species + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

