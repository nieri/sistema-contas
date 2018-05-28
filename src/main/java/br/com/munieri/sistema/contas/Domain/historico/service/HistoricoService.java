package br.com.munieri.sistema.contas.Domain.historico.service;

import br.com.munieri.sistema.contas.view.endpoint.transacao.TransacaoDTO;

import java.math.BigDecimal;

public interface HistoricoService {

    void salvarHistorico(TransacaoDTO dto, BigDecimal saldoContaOrigem, BigDecimal saldoContaDestino, BigDecimal saldoContaOrigemAtualizado, BigDecimal saldoContaDestinoAtualizado);

    void salvarHistorico(TransacaoDTO dto, BigDecimal saldoContaOrigem, BigDecimal saldoContaOrigemAtualizado);

}