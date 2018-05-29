package br.com.munieri.sistema.contas.domain.pessoa.repository;

import br.com.munieri.sistema.contas.domain.pessoa.PessoaFisica;
import br.com.munieri.sistema.contas.domain.pessoa.PessoaJuridica;

public interface PessoaCustonRepository {

    PessoaFisica findByCpf(String cpf);

    PessoaJuridica findByCnpj(String cnpj);
}
