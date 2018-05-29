package br.com.munieri.sistema.contas.domain.historico.service;

import br.com.munieri.sistema.contas.domain.historico.Historico;
import br.com.munieri.sistema.contas.domain.historico.repository.HistoritoRepository;
import br.com.munieri.sistema.contas.domain.transacao.TipoTransacao;
import br.com.munieri.sistema.contas.view.endpoint.transacao.TransacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class HistoricoServiceImpl implements HistoricoService {

    @Autowired
    HistoritoRepository historitoRepository;

    public Historico salvarHistorico(TransacaoDTO dto, BigDecimal saldoContaOrigem, BigDecimal saldoContaDestino, BigDecimal saldoContaOrigemAtualizado, BigDecimal saldoContaDestinoAtualizado) {
        Historico historico = new Historico(dto.getTipoTransacao(),
                dto.getCodigoTransacao(),
                dto.getValor(),
                dto.getContaOrigemId(),
                dto.getContaDestinoId(),
                saldoContaOrigem,
                saldoContaOrigemAtualizado,
                saldoContaDestino,
                saldoContaDestinoAtualizado);

        return historitoRepository.save(historico);
    }

    public Historico salvarHistorico(TransacaoDTO dto, BigDecimal saldoContaOrigem, BigDecimal saldoContaOrigemAtualizado) {
        Historico historico = new Historico(dto.getTipoTransacao(),
                dto.getCodigoTransacao(),
                dto.getValor(),
                dto.getContaOrigemId(),
                saldoContaOrigem,
                saldoContaOrigemAtualizado);

        return historitoRepository.save(historico);
    }

    public Historico salvarHistorico(TipoTransacao tipoTransacao,
                                     String codigoTransacao,
                                     BigDecimal valor,
                                     Long idContaOrigem,
                                     Long idContaDestino,
                                     BigDecimal saldoInicialContaOrigem,
                                     BigDecimal saldoFinalContaOrigem,
                                     BigDecimal saldoInicialContaDestino,
                                     BigDecimal saldoFinalContaDestino) {
        Historico historico = new Historico(tipoTransacao,
                codigoTransacao,
                valor,
                idContaOrigem,
                idContaDestino,
                saldoInicialContaOrigem,
                saldoFinalContaOrigem,
                saldoInicialContaDestino,
                saldoFinalContaDestino);

        return historitoRepository.save(historico);
    }


    @Override
    public Historico findByCodigoTransacao(String codigo) {

        Optional<Historico> transacao = historitoRepository.findByCodigoTransacao(codigo);
        if (transacao.isPresent()) {
            return transacao.get();
        }

        return null;
    }


}
