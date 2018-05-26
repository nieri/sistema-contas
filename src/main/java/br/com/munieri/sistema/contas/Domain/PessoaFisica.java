package br.com.munieri.sistema.contas.Domain;

import java.time.LocalDate;

public interface PessoaFisica extends Pessoa {

    String cpf();

    String nome();

    LocalDate dataNascimento();
}
