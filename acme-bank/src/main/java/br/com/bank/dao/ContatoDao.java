package br.com.bank.dao;

import br.com.bank.model.Contato;

import java.util.List;

public interface ContatoDao {

    void salvar(Contato contato);

    List<Contato> list();

    void update(Contato contato);

    void delete(Long id);

    Contato findById(Long id);
}
