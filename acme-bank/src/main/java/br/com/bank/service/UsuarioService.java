package br.com.bank.service;

import br.com.bank.model.Contato;
import br.com.bank.model.Usuario;

import java.util.List;

public interface UsuarioService {
    void salvar(Usuario usuario);

    List<Usuario> list();

    void delete(Long id);

    void update(Usuario usuario);

    Usuario findById(Long id);

    List<Usuario> findByLogin(String login);
}
