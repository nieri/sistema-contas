package br.com.munieri.sistema.contas.Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Conta {

    String nome();

    LocalDateTime dataCriacao();

    StatusConta statusConta();

    BigDecimal saldo();

    Pessoa pessoa();

}
