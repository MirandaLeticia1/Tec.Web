package br.com.bank.service;

import br.com.bank.model.Client;

import java.util.List;

public interface ClientService {

    Client getClient(String name);

    List<Client> getAll();

    void save(Client client);

    void deleteById(Long idClient);
}
