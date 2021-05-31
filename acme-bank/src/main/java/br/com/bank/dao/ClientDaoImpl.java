/**
 *
 */
package br.com.bank.dao;

import br.com.bank.model.Client;
import br.com.bank.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

/**
 * @author cbgomes
 *
 */
public class ClientDaoImpl implements ClientDao {

    @Override
    public Client getClient(String name) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {

            Client client = entityManager.createNamedQuery("Client.getByName", Client.class)
                    .setParameter("name", name)
                    .getSingleResult();

            return client;

        } catch (NoResultException e) {
            e.getMessage();
            entityManager.close();
        }

        return null;
    }

    @Override
    public List<Client> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Client client) {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {

            entityManager.persist(client);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Override
    public void deleteById(Long idClient) {
        // TODO Auto-generated method stub

    }

}
