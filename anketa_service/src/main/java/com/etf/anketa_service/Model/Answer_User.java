package com.etf.anketa_service.Model;

import javax.persistence.*;

@Entity
@Table(name = "Odgovor_Korisnika")
public class Answer_User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "odgovorKorisnika")
    private Survey_Question_Answer anketaPitanjeOdgovor;

    @ManyToOne
    @JoinColumn(name = "korisnikId", nullable = false)
    private User user;

    public Answer_User() {}

    public Answer_User(Survey_Question_Answer anketaPitanjeOdgovor, User user) {
        this.anketaPitanjeOdgovor = anketaPitanjeOdgovor;
        this.user = user;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Survey_Question_Answer getAnketaPitanjeOdgovor() {
        return anketaPitanjeOdgovor;
    }
    public void setAnketaPitanjeOdgovor(Survey_Question_Answer anketaPitanjeOdgovor) {
        this.anketaPitanjeOdgovor = anketaPitanjeOdgovor;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
