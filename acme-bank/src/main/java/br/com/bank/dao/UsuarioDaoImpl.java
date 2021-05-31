package br.com.bank.dao;


import br.com.bank.model.Usuario;
import br.com.bank.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public void salvar(Usuario usuario) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {

            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public List<Usuario> list() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT c FROM Usuario c");
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }

    @Override
    public void update(Usuario usuario) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.find(Usuario.class, usuario.getId());
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            entityManager.close();
            e.getMessage();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Usuario usuario = entityManager.find(Usuario.class, id);

            if (usuario.getId() == null) {
                throw new Exception("Não existe usuario para excluir.");
            }

            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public Usuario findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findByLogin(String login) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        return entityManager.createQuery("SELECT u FROM Usuario u where u.login = :login")
                .setParameter("login", login).getResultList();
    }
}
