package br.com.munieri.sistema.contas.Domain.conta;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "conta")
@Table(name = "conta")
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    public Conta() {
    }

    public Conta(String nome, StatusConta statusConta, BigDecimal saldo) {
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
        this.statusConta = statusConta;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusConta getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}