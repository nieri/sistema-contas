package br.com.munieri.sistema.contas.Domain;

import java.time.LocalDate;

public interface PessoaFisica {

    long cpf();
    String nome();
    LocalDate dataNascimento();
}
