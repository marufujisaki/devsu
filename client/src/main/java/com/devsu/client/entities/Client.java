package com.devsu.client.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Client extends Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="client_id")
    private int id;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private boolean status;

    public Client() {
        // empty constructor
    }
    public Client(String password, boolean status, String address, String name, int age, String genre, String identification, String phone) {
        this.password = password;
        this.status = status;
        this.setAddress(address);
        this.setName(name);
        this.setAge(age);
        this.setGenre(genre);
        this.setIdentification(identification);
        this.setPhone(phone);
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
