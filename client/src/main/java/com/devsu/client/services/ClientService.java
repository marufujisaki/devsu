package com.devsu.client.services;

import com.devsu.client.dao.ClientDao;
import com.devsu.client.dto.ClientDTO;
import com.devsu.client.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<Client> getAllClients() {
        return clientDao.findAll();
    }

    public Client getClientById(int id) {
        return clientDao.findById(id);
    }

    public Client createClient(ClientDTO dto) {
        Client client = new Client(dto.getPassword(), dto.isStatus(), dto.getAddress(), dto.getName(), dto.getAge(), dto.getGenre(), dto.getIdentification(), dto.getPhone());
        return clientDao.save(client);
    }

    public Client updateClient(int id, ClientDTO clientDetails) {
        Client client = clientDao.findById(id);
        if (client != null) {
            client.setName(clientDetails.getName());
            client.setPhone(clientDetails.getPhone());
            client.setAge(clientDetails.getAge());
            client.setGenre(clientDetails.getGenre());
            client.setAddress(clientDetails.getAddress());
            client.setIdentification(clientDetails.getIdentification());
            client.setStatus(clientDetails.isStatus());
            client.setPassword(clientDetails.getPassword());
            return clientDao.save(client);
        } else {
            return null;
        }
    }

    public void deleteClient(int id) {
        clientDao.deleteById(id);
    }
}
