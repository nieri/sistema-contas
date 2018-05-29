package br.com.munieri.sistema.contas.domain.transacao.service;

import br.com.munieri.sistema.contas.domain.conta.Conta;
import br.com.munieri.sistema.contas.domain.conta.service.ContaService;
import br.com.munieri.sistema.contas.domain.historico.Historico;
import br.com.munieri.sistema.contas.domain.historico.service.HistoricoService;
import br.com.munieri.sistema.contas.domain.transacao.TipoTransacao;
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
    public Historico create(TransacaoDTO dto) {

        if (TipoTransacao.TRANSFERENCIA.equals(dto.getTipoTransacao())) {
            return this.transferencia(dto);
        }

        if (TipoTransacao.APORTE.equals(dto.getTipoTransacao())) {
            return this.aporte(dto);
        }

        if (TipoTransacao.ESTORNO.equals(dto.getTipoTransacao())) {
            return this.estorno(dto);
        }

        return null;
    }

    private Historico estorno(TransacaoDTO dto) {

        Historico historico = historicoService.findByCodigoTransacao(dto.getCodigoTransacao());

        Conta contaOrigem = getConta(historico.getIdContaDestino());
        Conta contaDestino = getConta(historico.getIdContaOrigem());

        BigDecimal saldoContaOrigem = contaOrigem.getSaldo();
        BigDecimal saldoContaDestino = contaDestino.getSaldo();

        BigDecimal saldoContaOrigemAtualizado = saldoContaOrigem.subtract(historico.getValor());
        BigDecimal saldoContaDestinoAtualizado = saldoContaDestino.add(historico.getValor());

        contaOrigem.setSaldo(saldoContaOrigemAtualizado);
        contaDestino.setSaldo(saldoContaDestinoAtualizado);

        contaService.update(contaOrigem);
        contaService.update(contaDestino);

        return historicoService.salvarHistorico(dto.getTipoTransacao(),
                dto.geraCodigoTransacao(),
                historico.getValor(),
                contaOrigem.getId(),
                contaDestino.getId(),
                saldoContaOrigem,
                saldoContaOrigemAtualizado,
                saldoContaDestino,
                saldoContaDestinoAtualizado);
    }

    private Historico aporte(TransacaoDTO dto) {
        Conta contaOrigem = getConta(dto.getContaOrigemId());
        BigDecimal saldoContaOrigem = contaOrigem.getSaldo();
        BigDecimal saldoContaOrigemAtualizado = saldoContaOrigem.add(dto.getValor());
        contaOrigem.setSaldo(saldoContaOrigemAtualizado);
        contaService.update(contaOrigem);

        return historicoService.salvarHistorico(dto, saldoContaOrigem, saldoContaOrigemAtualizado);
    }

    private Historico transferencia(TransacaoDTO dto) {
        Conta contaOrigem = getConta(dto.getContaOrigemId());
        Conta contaDestino = getConta(dto.getContaDestinoId());

        BigDecimal saldoContaOrigem = contaOrigem.getSaldo();
        BigDecimal saldoContaDestino = contaDestino.getSaldo();

        BigDecimal saldoContaOrigemAtualizado = saldoContaOrigem.subtract(dto.getValor());
        BigDecimal saldoContaDestinoAtualizado = saldoContaDestino.add(dto.getValor());

        contaOrigem.setSaldo(saldoContaOrigemAtualizado);
        contaDestino.setSaldo(saldoContaDestinoAtualizado);

        contaService.update(contaOrigem);
        contaService.update(contaDestino);

        return historicoService.salvarHistorico(dto, saldoContaOrigem, saldoContaDestino, saldoContaOrigemAtualizado, saldoContaDestinoAtualizado);
    }

    private Conta getConta(Long contaOrigemId) {
        return contaService.findById(contaOrigemId);
    }
}
