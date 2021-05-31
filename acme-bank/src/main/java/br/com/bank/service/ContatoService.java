/**
 *
 */
package br.com.bank.service;

import br.com.bank.model.Contato;

import java.util.List;

/**
 * @author cbgomes
 *
 */
public interface ContatoService {

    void salvar(Contato contato);

    List<Contato> list();

    void delete(Long id);

    void update(Contato contato);

    Contato findById(Long id);
}
