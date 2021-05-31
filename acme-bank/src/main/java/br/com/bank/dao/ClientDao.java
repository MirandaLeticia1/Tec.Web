package br.com.bank.dao;

import br.com.bank.model.Client;

import java.util.List;

public interface ClientDao {

    Client getClient(String name);

    List<Client> getAll();

    void save(Client client);

    void deleteById(Long idClient);
}
