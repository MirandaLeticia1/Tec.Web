package br.com.bank.service;

import br.com.bank.dao.UsuarioDaoImpl;
import br.com.bank.model.Usuario;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDaoImpl dao;

    public UsuarioServiceImpl() {
        this.dao = new UsuarioDaoImpl();
    }

    @Override
    public void salvar(Usuario usuario) {
        this.dao.salvar(usuario);
    }

    @Override
    public List<Usuario> list() {
        return this.dao.list();
    }

    @Override
    public void delete(Long id) {
        this.dao.delete(id);
    }

    @Override
    public void update(Usuario usuario) {
        this.dao.update(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return this.dao.findById(id);
    }

    @Override
    public List<Usuario> findByLogin(String login) {
        return this.dao.findByLogin(login);
    }
}
