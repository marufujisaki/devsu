package com.devsu.client.dao;

import com.devsu.client.entities.Client;

import java.util.List;

public interface ClientDao {
    List<Client> findAll();
    Client findById(int id);
    Client save(Client client);
    void deleteById(int id);
}
