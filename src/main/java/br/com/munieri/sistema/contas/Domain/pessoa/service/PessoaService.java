package br.com.munieri.sistema.contas.Domain.pessoa.service;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;

import java.util.List;

public interface PessoaService {

    List<Pessoa> findAll();

    Pessoa findById(Long id);

    Pessoa create(Pessoa pessoa);

    Pessoa update(Pessoa pessoa);

    void delete(Long id);
}
