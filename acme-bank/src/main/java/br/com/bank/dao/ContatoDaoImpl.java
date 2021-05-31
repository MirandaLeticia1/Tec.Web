/**
 *
 */
package br.com.bank.dao;

import br.com.bank.model.Contato;
import br.com.bank.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author cbgomes
 *
 */
public class ContatoDaoImpl implements ContatoDao {

    @Override
    public void salvar(Contato contato) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {

            entityManager.persist(contato);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Override
    public List<Contato> list() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT c FROM Contato c");
        List<Contato> contatos = query.getResultList();
        return contatos;

    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Contato contato = entityManager.find(Contato.class, id);

            if (contato.getId() == null) {
                throw new Exception("Não existe contato para excluir.");
            }

            entityManager.remove(contato);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void update(Contato contato) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.find(Contato.class, contato.getId());
            entityManager.merge(contato);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            entityManager.close();
            e.getMessage();
        }
    }

    @Override
    public Contato findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        return entityManager.find(Contato.class, id);
    }
}









