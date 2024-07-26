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

    public List<ClientDTO> getAllClients() {
        return clientDao.findAll().stream().map(x -> new ClientDTO(x.getId(), x.getPassword(), x.isStatus(), x.getPersonId(), x.getName(), x.getAge(), x.getGenre(), x.getIdentification(), x.getPhone(), x.getAddress())).toList();
    }

    public Client getClientById(int id) {
        return clientDao.findById(id);
    }

    public ClientDTO createClient(ClientDTO dto) {
        Client client = new Client(dto.getPassword(), dto.isStatus(), dto.getAddress(), dto.getName(), dto.getAge(), dto.getGenre(), dto.getIdentification(), dto.getPhone());
        clientDao.save(client);
        return new ClientDTO(client.getId(),client.getPassword(),client.isStatus(),client.getPersonId(),client.getName(),client.getAge(),client.getGenre(),client.getIdentification(),client.getPhone(),client.getAddress());
    }

    public ClientDTO updateClient(int id, ClientDTO clientDetails) {
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
            clientDao.save(client);
            return new ClientDTO(client.getId(),client.getPassword(),client.isStatus(),client.getPersonId(),client.getName(),client.getAge(),client.getGenre(),client.getIdentification(),client.getPhone(),client.getAddress());
        } else {
            return null;
        }
    }

    public void deleteClient(int id) {
        clientDao.deleteById(id);
    }
}
