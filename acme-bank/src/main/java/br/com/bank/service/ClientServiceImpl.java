/**
 *
 */
package br.com.bank.service;

import br.com.bank.dao.ClientDaoImpl;
import br.com.bank.model.Client;

import java.util.List;

/**
 * @author cbgomes
 *
 */
public class ClientServiceImpl implements ClientService {

    private final ClientDaoImpl dao;

    public ClientServiceImpl() {
        this.dao = new ClientDaoImpl();
    }

    @Override
    public Client getClient(String name) {

        return this.dao.getClient(name);
    }

    @Override
    public List<Client> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Client client) {
        this.dao.save(client);
    }

    @Override
    public void deleteById(Long idClient) {
        // TODO Auto-generated method stub

    }


}
