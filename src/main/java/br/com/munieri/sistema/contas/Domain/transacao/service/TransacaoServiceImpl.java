package br.com.munieri.sistema.contas.Domain.transacao.service;

import br.com.munieri.sistema.contas.Domain.conta.Conta;
import br.com.munieri.sistema.contas.Domain.conta.service.ContaService;
import br.com.munieri.sistema.contas.Domain.historico.service.HistoricoService;
import br.com.munieri.sistema.contas.Domain.transacao.TipoTransacao;
import br.com.munieri.sistema.contas.view.endpoint.transacao.TransacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    ContaService contaService;

    @Autowired
    HistoricoService historicoService;

    @Override
    public void create(TransacaoDTO dto) {

        if (TipoTransacao.TRANSFERENCIA.equals(dto.getTipoTransacao())) {
            this.transferencia(dto);
        }

        if (TipoTransacao.APORTE.equals(dto.getTipoTransacao())) {
            this.aporte(dto);
        }

        if (TipoTransacao.ESTORNO.equals(dto.getTipoTransacao())) {
            this.estorno(dto);
        }
    }

    private void estorno(TransacaoDTO dto) {
    }

    private void aporte(TransacaoDTO dto) {
        Conta contaOrigem = getConta(dto.getContaOrigemId());
        BigDecimal saldoContaOrigem = contaOrigem.getSaldo();
        BigDecimal saldoContaOrigemAtualizado = saldoContaOrigem.min(dto.getValor());
        contaOrigem.setSaldo(saldoContaOrigemAtualizado);
        contaService.update(contaOrigem);

        historicoService.salvarHistorico(dto, saldoContaOrigem, saldoContaOrigemAtualizado);
    }

    private void transferencia(TransacaoDTO dto) {
        Conta contaOrigem = getConta(dto.getContaOrigemId());
        Conta contaDestino = getConta(dto.getContaDestinoId());

        BigDecimal saldoContaOrigem = contaOrigem.getSaldo();
        BigDecimal saldoContaDestino = contaDestino.getSaldo();

        BigDecimal saldoContaOrigemAtualizado = saldoContaOrigem.min(dto.getValor());
        BigDecimal saldoContaDestinoAtualizado = saldoContaDestino.max(dto.getValor());

        contaOrigem.setSaldo(saldoContaOrigemAtualizado);
        contaDestino.setSaldo(saldoContaDestinoAtualizado);

        contaService.update(contaOrigem);
        contaService.update(contaDestino);

        historicoService.salvarHistorico(dto, saldoContaOrigem, saldoContaDestino, saldoContaOrigemAtualizado, saldoContaDestinoAtualizado);
    }

    private Conta getConta(Long contaOrigemId) {
        return contaService.findById(contaOrigemId);
    }
}
