package br.com.munieri.sistema.contas.Domain.pessoa.service;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;

import java.util.List;

public interface PessoaService {

    List<Pessoa> findAll();
}
