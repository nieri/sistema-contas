package br.com.munieri.sistema.contas.Domain.transacao.service;

import br.com.munieri.sistema.contas.Domain.historico.Historico;
import br.com.munieri.sistema.contas.view.endpoint.transacao.TransacaoDTO;

public interface TransacaoService {

    Historico create(TransacaoDTO dto);

}
