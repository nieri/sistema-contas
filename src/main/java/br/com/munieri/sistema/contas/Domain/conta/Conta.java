package br.com.munieri.sistema.contas.Domain.conta;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "conta")
@Table(name = "conta")
public class Conta {

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
    private Pessoa pessoa;

    public Conta() {
    }

    public Conta(String nome, StatusConta statusConta, BigDecimal saldo, Pessoa pessoa) {
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
        this.statusConta = statusConta;
        this.saldo = saldo;
        this.pessoa = pessoa;
    }



}