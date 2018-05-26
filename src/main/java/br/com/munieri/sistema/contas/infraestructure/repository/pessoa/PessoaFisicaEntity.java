package br.com.munieri.sistema.contas.infraestructure.repository.pessoa;

import br.com.munieri.sistema.contas.Domain.PessoaFisica;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa_fisica")
@DiscriminatorValue("pessoa_fisica")

public class PessoaFisicaEntity extends PessoaEntity implements PessoaFisica {

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "nome", nullable = false, length = 100)
    private String name;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    public PessoaFisicaEntity() {
    }

    public PessoaFisicaEntity(String cpf, String name, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.name = name;
        this.dataNascimento = dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String cpf() {
        return this.cpf;
    }

    @Override
    public String nome() {
        return this.name;
    }

    @Override
    public LocalDate dataNascimento() {
        return this.dataNascimento;
    }
}
