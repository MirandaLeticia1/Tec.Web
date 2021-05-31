package br.com.bank.dao;

import br.com.bank.model.Usuario;

import java.util.List;

public interface UsuarioDao {

    void salvar(Usuario usuario);

    List<Usuario> list();

    void update(Usuario usuario);

    void delete(Long id);

    Usuario findById(Long id);

    List<Usuario> findByLogin(String login);
}
