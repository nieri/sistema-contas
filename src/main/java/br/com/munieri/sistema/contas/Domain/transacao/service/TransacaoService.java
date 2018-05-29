package br.com.munieri.sistema.contas.domain.transacao.service;

import br.com.munieri.sistema.contas.domain.historico.Historico;
import br.com.munieri.sistema.contas.view.endpoint.transacao.TransacaoDTO;

public interface TransacaoService {

    Historico create(TransacaoDTO dto);

}
