package br.com.munieri.sistema.contas.view.endpoint.conta.service;

import br.com.munieri.sistema.contas.Domain.conta.Conta;
import br.com.munieri.sistema.contas.view.endpoint.conta.ContaDTO;

import java.util.List;

public interface ContaService {

    List<Conta> findAll();

    Conta findById(Long id);

    Conta create(ContaDTO dto);

    void delete(Long id);

}
