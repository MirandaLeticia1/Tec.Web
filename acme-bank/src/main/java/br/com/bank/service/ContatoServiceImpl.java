/**
 *
 */
package br.com.bank.service;

import br.com.bank.dao.ContatoDaoImpl;
import br.com.bank.model.Contato;

import java.util.List;

/**
 * @author cbgomes
 *
 */
public class ContatoServiceImpl implements ContatoService {

    private final ContatoDaoImpl dao;

    public ContatoServiceImpl() {
        this.dao = new ContatoDaoImpl();
    }

    @Override
    public void salvar(Contato contato) {
        this.dao.salvar(contato);
    }

    @Override
    public List<Contato> list() {
        return this.dao.list();
    }

    @Override
    public void delete(Long id) {
        this.dao.delete(id);
    }

    @Override
    public void update(Contato contato) {
        this.dao.update(contato);
    }

    @Override
    public Contato findById(Long id) {
        return this.dao.findById(id);
    }
}
