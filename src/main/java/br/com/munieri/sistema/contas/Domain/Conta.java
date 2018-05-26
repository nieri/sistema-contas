package br.com.munieri.sistema.contas.Domain;

import java.time.LocalDateTime;

public interface Conta {

    String nome();

    LocalDateTime dataCriacao();

    Pessoa pessoa();

}
