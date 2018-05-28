package br.com.munieri.sistema.contas.Domain.historico;

import br.com.munieri.sistema.contas.Domain.transacao.TipoTransacao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico")
public class Historico {

    @Id
    @SequenceGenerator(name = "seq_historico", sequenceName = "seq_historico")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_historico")
    private Long id;

    @Column(name = "tipo_transacao", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    @Column(name = "codigo_transacao", nullable = false)
    private String codigoTransacao;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "id_conta_origem", nullable = false)
    private Long idContaOrigem;

    @Column(name = "saldo_inicial_conta_origem", nullable = false)
    private BigDecimal saldoInicialContaOrigem;

    @Column(name = "saldo_final_conta_origem", nullable = false)
    private BigDecimal saldoFinalContaOrigem;

    @Column(name = "id_conta_destino")
    private Long idContaDestino;

    @Column(name = "saldo_inicial_conta_destino")
    private BigDecimal saldoInicialContaDestino;

    @Column(name = "saldo_final_conta_destino")
    private BigDecimal saldoFinalContaDestino;

    @Column(name = "data_transacao" , nullable = false)
    private LocalDateTime dataTransacao;

    public Historico() {
    }

    public Historico(TipoTransacao tipoTransacao, String codigoTransacao, BigDecimal valor, Long idContaOrigem, Long idContaDestino, BigDecimal saldoInicialContaOrigem, BigDecimal saldoFinalContaOrigem, BigDecimal saldoInicialContaDestino, BigDecimal saldoFinalContaDestino) {
        this.tipoTransacao = tipoTransacao;
        this.codigoTransacao = codigoTransacao;
        this.valor = valor;
        this.idContaOrigem = idContaOrigem;
        this.saldoInicialContaOrigem = saldoInicialContaOrigem;
        this.saldoFinalContaOrigem = saldoFinalContaOrigem;
        this.idContaDestino = idContaDestino;
        this.saldoInicialContaDestino = saldoInicialContaDestino;
        this.saldoFinalContaDestino = saldoFinalContaDestino;
        this.dataTransacao = LocalDateTime.now();
    }

    public Historico(TipoTransacao tipoTransacao, String codigoTransacao, BigDecimal valor, Long idContaOrigem, BigDecimal saldoInicialContaOrigem, BigDecimal saldoFinalContaOrigem) {
        this.tipoTransacao = tipoTransacao;
        this.codigoTransacao = codigoTransacao;
        this.valor = valor;
        this.idContaOrigem = idContaOrigem;
        this.saldoInicialContaOrigem = saldoInicialContaOrigem;
        this.saldoFinalContaOrigem = saldoFinalContaOrigem;
        this.dataTransacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public void setCodigoTransacao(String codigoTransacao) {
        this.codigoTransacao = codigoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getIdContaOrigem() {
        return idContaOrigem;
    }

    public void setIdContaOrigem(Long idContaOrigem) {
        this.idContaOrigem = idContaOrigem;
    }

    public BigDecimal getSaldoInicialContaOrigem() {
        return saldoInicialContaOrigem;
    }

    public void setSaldoInicialContaOrigem(BigDecimal saldoInicialContaOrigem) {
        this.saldoInicialContaOrigem = saldoInicialContaOrigem;
    }

    public BigDecimal getSaldoFinalContaOrigem() {
        return saldoFinalContaOrigem;
    }

    public void setSaldoFinalContaOrigem(BigDecimal saldoFinalContaOrigem) {
        this.saldoFinalContaOrigem = saldoFinalContaOrigem;
    }

    public Long getIdContaDestino() {
        return idContaDestino;
    }

    public void setIdContaDestino(Long idContaDestino) {
        this.idContaDestino = idContaDestino;
    }

    public BigDecimal getSaldoInicialContaDestino() {
        return saldoInicialContaDestino;
    }

    public void setSaldoInicialContaDestino(BigDecimal saldoInicialContaDestino) {
        this.saldoInicialContaDestino = saldoInicialContaDestino;
    }

    public BigDecimal getSaldoFinalContaDestino() {
        return saldoFinalContaDestino;
    }

    public void setSaldoFinalContaDestino(BigDecimal saldoFinalContaDestino) {
        this.saldoFinalContaDestino = saldoFinalContaDestino;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
