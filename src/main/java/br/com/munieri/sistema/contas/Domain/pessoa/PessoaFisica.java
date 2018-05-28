package br.com.munieri.sistema.contas.Domain.pessoa;

import br.com.munieri.sistema.contas.Domain.conta.Conta;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pessoa_fisica")
@DiscriminatorValue("pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class PessoaFisica extends Pessoa {

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "nome", length = 100)
    private String name;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(String cpf, String name, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.setDataCriacao(LocalDateTime.now());
    }

    public PessoaFisica(String cpf, String name, LocalDate dataNascimento, Conta conta) {
        this.cpf = cpf;
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.setDataCriacao(LocalDateTime.now());
        this.getContas().add(conta);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
