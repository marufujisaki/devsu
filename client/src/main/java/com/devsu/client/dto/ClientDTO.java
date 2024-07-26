package com.devsu.client.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ClientDTO implements Serializable {
    private int clientId;
    @NotNull
    private String password;
    @NotNull
    private boolean status;
    private int personId;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @NotNull
    private String genre;
    @NotNull
    private String identification;
    @NotNull
    private String phone;
    @NotNull
    private String address;

    public ClientDTO(int clientId, String password, boolean status, int personId, String name, int age, String genre, String identification, String phone, String address) {
        this.clientId = clientId;
        this.password = password;
        this.status = status;
        this.personId = personId;
        this.name = name;
        this.age = age;
        this.genre = genre;
        this.identification = identification;
        this.phone = phone;
        this.address = address;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
