package br.com.munieri.sistema.contas.view.endpoint.pessoa.fisica;

import br.com.munieri.sistema.contas.Domain.pessoa.PessoaFisica;

import java.time.LocalDate;

public class PessoaFisicaDTO {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public PessoaFisicaDTO() {
    }

    public PessoaFisicaDTO(PessoaFisica pessoaFisica) {
        this.nome = pessoaFisica.getName();
        this.cpf = pessoaFisica.getCpf();
        this.dataNascimento = pessoaFisica.getDataNascimento();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}