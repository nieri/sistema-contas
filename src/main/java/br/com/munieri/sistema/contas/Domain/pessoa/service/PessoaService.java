package br.com.munieri.sistema.contas.Domain.pessoa.service;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;
import br.com.munieri.sistema.contas.Domain.pessoa.PessoaFisica;
import br.com.munieri.sistema.contas.Domain.pessoa.PessoaJuridica;

import java.util.List;

public interface PessoaService {

    List<Pessoa> findAll();

    Pessoa findById(Long id);

    Pessoa findByCpf(String cpf);

    Pessoa findByCnpj(String cnpj);

    Pessoa create(Pessoa pessoa);

    Pessoa update(Pessoa pessoa);

    Pessoa update(PessoaFisica pessoa);

    Pessoa update(PessoaJuridica pessoa);

    void delete(Long id);
}
