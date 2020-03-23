package com.example.zivotinja.model;

import javax.persistence.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@Entity
public class Zivotinja {

    // Atributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String Ime;
    private String Vrsta;
    private String Rasa;
    private String Spol;
    private int Godine;
    private String Velicina;
    private int Tezina;
    private String dodatniOpis;
    private boolean Udomljena;

    @Lob
    private byte[] Slika;

    // Relacije
    // Vakcina n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "vakcina_zivotinja",
               joinColumns = {
                    @JoinColumn(name = "zivotinjaID", referencedColumnName = "id", nullable = false, updatable = false)},
               inverseJoinColumns = {
                    @JoinColumn(name = "vakcinaID", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Vakcina> Vakcine = new HashSet<>();

    // Veterinar n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "veterinar_zivotinja",
            joinColumns = {
                    @JoinColumn(name = "zivotinjaID", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "veterinarID", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Veterinar> Veterinari = new HashSet<>();

    // Bolest n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "bolest_zivotinja",
            joinColumns = {
                    @JoinColumn(name = "zivotinjaID", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "bolestID", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Bolest> Bolesti = new HashSet<>();

    // Korisnik n-n
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "korisnik_zivotinja",
            joinColumns = {
                    @JoinColumn(name = "zivotinjaID", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "korisnikID", referencedColumnName = "id", nullable = false, updatable = false)})
    private Set<Korisnik> Korisnici = new HashSet<>();

    // Konstruktori
    public Zivotinja() {}
    public Zivotinja (String ime, String vrsta, String rasa, String spol, int godine, String velicina, int tezina,  String opis, boolean udomljena, byte[] slika) {
        Ime = ime;
        Vrsta = vrsta;
        Rasa = rasa;
        Spol = spol;
        Godine = godine;
        Velicina = velicina;
        Tezina = tezina;
        Slika = slika;
        dodatniOpis = opis;
        Udomljena = udomljena;
    }

    public Zivotinja (String ime, String vrsta, String rasa, String spol, int godine, String velicina, int tezina,  String opis, boolean udomljena) {
        Ime = ime;
        Vrsta = vrsta;
        Rasa = rasa;
        Spol = spol;
        Godine = godine;
        Velicina = velicina;
        Tezina = tezina;
        dodatniOpis = opis;
        Udomljena = udomljena;
    }

    // Getters
    public String getIme()  { return Ime; }
    public String getVrsta() { return  Vrsta; }
    public String getRasa() {return Rasa; }
    public int getGodine() { return Godine; }
    public String getSpol() { return  Spol; }
    public String getVelicina() { return  Velicina; }
    public int getTezina() { return Tezina; }
    public boolean isUdomljena() { return Udomljena; }
    public Long getId() { return id; }
    public String getDodatniOpis() { return dodatniOpis; }
    public byte[] getSlika() { return Slika; }

    public Set<Bolest> getBolesti() { return Bolesti; }
    public Set<Korisnik> getKorisnici() { return Korisnici; }
    public Set<Vakcina> getVakcine() { return Vakcine; }
    public Set<Veterinar> getVeterinari() { return Veterinari; }

    // Setters
    public void setIme(String ime) { Ime = ime; }
    public void setDodatniOpis(String dodatniOpis) {
        this.dodatniOpis = dodatniOpis;
    }
    public void setGodine(int godine) {
        Godine = godine;
    }
    public void setRasa(String rasa) {
        Rasa = rasa;
    }
    public void setSlika( byte[] slika) { Slika = slika; }
    public void setSpol(String spol) {
        Spol = spol;
    }
    public void setTezina(int tezina) {
        Tezina = tezina;
    }
    public void setVelicina(String velicina) {
        Velicina = velicina;
    }
    public void setVrsta(String vrsta) {
        Vrsta = vrsta;
    }
    public void setUdomljena(boolean udomljena) {
        Udomljena = udomljena;
    }
    public void setId(Long id) { this.id = id; }

    // Metode

    // Metoda za kreiranje i snimanje slike u bazu
    public byte[] kreirajSliku (String putanja) {
        File slika = new File (putanja);
        byte[] bFile = new byte[ (int) slika.length()];
        try {
            FileInputStream iStream = new FileInputStream(slika);

            // Konverzija u niz byte
            iStream.read(bFile);
            iStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bFile;
    }

    // Metoda za preuzimanje slike iz baze i spremanje lokalno
    public void preuzmiSliku() {
        byte[] slika = this.getSlika();
        try {
            FileOutputStream oStream = new FileOutputStream("C:\\Users\\belma\\Desktop\\NWT2020-petFriend\\zivotinja-service\\Slike iz baze\\test.jpg");
            oStream.write(slika);
            oStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String ZivotinjaNotFoundException(Long id) {
        return ("Could not find employee " + id);
    }
}
