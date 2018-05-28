package br.com.munieri.sistema.contas.Domain.transacao.service;

import br.com.munieri.sistema.contas.view.endpoint.transacao.TransacaoDTO;

public interface TransacaoService {

    void create(TransacaoDTO dto);

}
