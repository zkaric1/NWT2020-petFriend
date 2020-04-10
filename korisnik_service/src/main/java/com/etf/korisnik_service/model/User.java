package com.etf.korisnik_service.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Ime i prezime su obavezni!")
    @Pattern(regexp = "[A-Za-z \\s-]*", message = "Nije validan unos imena i prezimena")
    private String fullName;

    // @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", message = "Datum mora biti formata dd/mm/yyyy")
    private Date dateOfBirth;

    @Pattern(regexp = "/^\\S+@\\S+\\.\\S+$/", message = "Email nije dobrog formata")
    private String email;

    @Pattern(regexp = "[\\w\\d]{7,}", message = "Sifra mora imati minimalno 7 znakova (karaktera ili brojeva)")
    private String password;

    @Pattern(regexp = "[A-Za-z \\s-]*", message = "Nije validan unos adrese")
    private String address;

    private String phoneNumber;

    @NotBlank(message = "Maticni broj je obavezan")
    private String jmbg;

    @Pattern(regexp = "^(M|Z)$", message = "Spol moze biti M ili Z")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    private Role role;

    public User() {
    }

    public User(String fullName, Date dateOfBirth, String email, String password, String address, String phoneNumber, String jmbg, String gender) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.jmbg = jmbg;
        this.gender = gender;
    }

    public User(String fullName, String jmbg, Role role) {
        this.fullName = fullName;
        this.jmbg = jmbg;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String imePrezime) {
        this.fullName = imePrezime;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date datumRodjenja) {
        this.dateOfBirth = datumRodjenja;
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

    public void setPassword(String sifra) {
        this.password = sifra;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adresa) {
        this.address = adresa;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String telefon) {
        this.phoneNumber = telefon;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String maticniBroj) {
        this.jmbg = maticniBroj;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String spol) {
        this.gender = spol;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role roleId) {
        this.role = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", gender='" + gender + '\'' +
                ", roleId=" + role +
                '}';
    }
}

