package br.com.munieri.sistema.contas.Domain;

public interface PessoaJuridica extends Pessoa {

    String cnpj();

    String nomeFantasia();

    String razaoSocial();
}
