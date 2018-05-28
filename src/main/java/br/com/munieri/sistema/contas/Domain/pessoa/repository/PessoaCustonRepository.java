package br.com.munieri.sistema.contas.Domain.pessoa.repository;

import br.com.munieri.sistema.contas.Domain.pessoa.PessoaFisica;
import br.com.munieri.sistema.contas.Domain.pessoa.PessoaJuridica;

public interface PessoaCustonRepository {

    PessoaFisica findByCpf(String cpf);

    PessoaJuridica findByCnpj(String cnpj);
}
