package br.com.munieri.sistema.contas.Domain.pessoa;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa_fisica")
@DiscriminatorValue("pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id_pessoa_fisica")
public class PessoaFisica extends Pessoa {

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "nome", nullable = false, length = 100)
    private String name;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(String cpf, String name, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.name = name;
        this.dataNascimento = dataNascimento;
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
