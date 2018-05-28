package br.com.munieri.sistema.contas.Domain.historico.service;

import br.com.munieri.sistema.contas.Domain.historico.Historico;
import br.com.munieri.sistema.contas.Domain.historico.repository.HistoritoRepository;
import br.com.munieri.sistema.contas.view.endpoint.transacao.TransacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class HistoricoServiceImpl implements HistoricoService {

    @Autowired
    HistoritoRepository historitoRepository;

    public void salvarHistorico(TransacaoDTO dto, BigDecimal saldoContaOrigem, BigDecimal saldoContaDestino, BigDecimal saldoContaOrigemAtualizado, BigDecimal saldoContaDestinoAtualizado) {
        Historico historico = new Historico(dto.getTipoTransacao(),
                dto.getCodigoTransacao(),
                dto.getValor(),
                dto.getContaOrigemId(),
                dto.getContaDestinoId(),
                saldoContaOrigem,
                saldoContaOrigemAtualizado,
                saldoContaDestino,
                saldoContaDestinoAtualizado);

        historitoRepository.save(historico);
    }

    public void salvarHistorico(TransacaoDTO dto, BigDecimal saldoContaOrigem, BigDecimal saldoContaOrigemAtualizado) {
        Historico historico = new Historico(dto.getTipoTransacao(),
                dto.getCodigoTransacao(),
                dto.getValor(),
                dto.getContaOrigemId(),
                saldoContaOrigem,
                saldoContaOrigemAtualizado);

        historitoRepository.save(historico);
    }
}
