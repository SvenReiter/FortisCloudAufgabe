package com.restdemo.model;

import jakarta.persistence.*;

@Entity     //available by dependency spring-boot-starter-data-jpa
@Table(name="USERTABLE")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String vorname;
    private String nachname;
    private String email;
    private String adresse;

    public User() {super();}
    public User(String vornameArg, String nachnameArg, String adresseArg, String emailArg) {
        super();
        vorname= vornameArg;
        nachname= nachnameArg;
        email= emailArg;
        adresse= adresseArg;
    }

    class UserShort {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + vorname + nachname + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
