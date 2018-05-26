package br.com.munieri.sistema.contas.infraestructure.repository;

import br.com.munieri.sistema.contas.Domain.PessoaFisica;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisicaEntity implements PessoaFisica {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ITEM_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "cpf", nullable = false, length = 11)
    private Long cpf;

    @Column(name = "nome", nullable = false, length = 100)
    private String name;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    public PessoaFisicaEntity(Long cpf, String name, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.name = name;
        this.dataNascimento = dataNascimento;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public long cpf() {
        return 0;
    }

    @Override
    public String nome() {
        return null;
    }

    @Override
    public LocalDate dataNascimento() {
        return null;
    }
}
