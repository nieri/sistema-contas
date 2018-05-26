package br.com.munieri.sistema.contas.infraestructure.repository.conta;

import br.com.munieri.sistema.contas.Domain.Conta;
import br.com.munieri.sistema.contas.Domain.Pessoa;
import br.com.munieri.sistema.contas.infraestructure.repository.pessoa.PessoaEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "conta")
@Table(name = "conta")
public class ContaEntity implements Conta {

    @Id
    @SequenceGenerator(name = "seq_conta", sequenceName = "seq_conta")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private PessoaEntity pessoa;

    public ContaEntity(String nome, PessoaEntity pessoa) {
        this.nome = nome;
        this.pessoa = pessoa;
    }

    @Override
    public String nome() {
        return this.nome;
    }

    @Override
    public LocalDateTime dataCriacao() {
        return this.dataCriacao();
    }

    @Override
    public Pessoa pessoa() {
        return this.pessoa();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }
}
