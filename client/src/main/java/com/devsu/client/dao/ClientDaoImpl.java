package com.devsu.client.dao;

import com.devsu.client.dto.ClientDTO;
import com.devsu.client.entities.Client;
import com.devsu.client.repositories.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    private final ClientRepository clientRepository;

    public ClientDaoImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }
}
