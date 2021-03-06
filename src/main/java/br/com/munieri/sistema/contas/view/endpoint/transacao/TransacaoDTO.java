package br.com.munieri.sistema.contas.view.endpoint.transacao;

import br.com.munieri.sistema.contas.domain.transacao.TipoTransacao;

import java.math.BigDecimal;
import java.util.UUID;

public class TransacaoDTO {

    private TipoTransacao tipoTransacao;
    private BigDecimal valor;
    private Long contaOrigemId;
    private Long contaDestinoId;
    private String codigoTransacao;

    public String geraCodigoTransacao() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        this.codigoTransacao = uuid;
        return uuid;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getContaOrigemId() {
        return contaOrigemId;
    }

    public void setContaOrigemId(Long contaOrigemId) {
        this.contaOrigemId = contaOrigemId;
    }

    public Long getContaDestinoId() {
        return contaDestinoId;
    }

    public void setContaDestinoId(Long contaDestinoId) {
        this.contaDestinoId = contaDestinoId;
    }

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public void setCodigoTransacao(String codigoTransacao) {
        this.codigoTransacao = codigoTransacao;
    }
}
