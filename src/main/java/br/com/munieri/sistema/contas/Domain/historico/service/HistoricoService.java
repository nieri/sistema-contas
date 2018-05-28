package br.com.munieri.sistema.contas.Domain.historico.service;

import br.com.munieri.sistema.contas.Domain.historico.Historico;
import br.com.munieri.sistema.contas.Domain.transacao.TipoTransacao;
import br.com.munieri.sistema.contas.view.endpoint.transacao.TransacaoDTO;

import java.math.BigDecimal;

public interface HistoricoService {

    Historico salvarHistorico(TransacaoDTO dto, BigDecimal saldoContaOrigem, BigDecimal saldoContaDestino, BigDecimal saldoContaOrigemAtualizado, BigDecimal saldoContaDestinoAtualizado);

    Historico salvarHistorico(TransacaoDTO dto, BigDecimal saldoContaOrigem, BigDecimal saldoContaOrigemAtualizado);

    Historico salvarHistorico(TipoTransacao tipoTransacao,
                              String codigoTransacao,
                              BigDecimal valor,
                              Long idContaOrigem,
                              Long idContaDestino,
                              BigDecimal saldoInicialContaOrigem,
                              BigDecimal saldoFinalContaOrigem,
                              BigDecimal saldoInicialContaDestino,
                              BigDecimal saldoFinalContaDestino);

    Historico findByCodigoTransacao(String codigo);
}