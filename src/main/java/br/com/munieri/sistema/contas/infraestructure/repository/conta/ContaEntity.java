package br.com.munieri.sistema.contas.infraestructure.repository.conta;

import br.com.munieri.sistema.contas.Domain.Conta;
import br.com.munieri.sistema.contas.Domain.Pessoa;
import br.com.munieri.sistema.contas.Domain.StatusConta;
import br.com.munieri.sistema.contas.infraestructure.repository.pessoa.PessoaEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "conta")
@Table(name = "conta")
public class ContaEntity implements Conta {

    @Id
    @SequenceGenerator(name = "seq_conta", sequenceName = "seq_conta")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "status", nullable = false)
    private StatusConta statusConta;

    @Column(name = "saldo", nullable = false, length = 10)
    private BigDecimal saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private PessoaEntity pessoa;

    public ContaEntity() {
    }

    public ContaEntity(String nome, StatusConta statusConta, BigDecimal saldo, PessoaEntity pessoa) {
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
        this.statusConta = statusConta;
        this.saldo = saldo;
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
    public StatusConta statusConta() {
        return this.statusConta;
    }

    @Override
    public BigDecimal saldo() {
        return this.saldo;
    }

    @Override
    public Pessoa pessoa() {
        return this.pessoa();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setStatusConta(StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }
}
