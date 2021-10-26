package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Category;
import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client cls) {
        if (cls.getIdClient() == null) {
            return clientRepository.save(cls);
        } else {
            Optional<Client> clientAuxiliar = clientRepository.getClient(cls.getIdClient());
            if (clientAuxiliar.isEmpty()) {
                return clientRepository.save(cls);
            } else {
                return cls;
            }
        }
    }

    public Client update(Client cup) {
        if (cup.getIdClient() != null) {
            Optional<Client> clientAuxiliar = clientRepository.getClient(cup.getIdClient());
            if (clientAuxiliar.isPresent()) {
                if (cup.getEmail() != null) {
                    clientAuxiliar.get().setEmail(cup.getEmail());
                }
                if (cup.getPassword() != null) {
                    clientAuxiliar.get().setPassword(cup.getPassword());
                }
                if (cup.getName() != null) {
                    clientAuxiliar.get().setName(cup.getName());
                }
                if (cup.getAge() != null) {
                    clientAuxiliar.get().setAge(cup.getAge());
                }
                return clientRepository.save(clientAuxiliar.get());
            }
        }
        return cup;

    }

    public boolean deleteClient(int id) {
        Optional<Client> clientAuxiliar = getClient(id);
        if (clientAuxiliar.isPresent()) {
            clientRepository.delete(clientAuxiliar.get());
            return true;
        }
        return false;

    }

}
