package br.com.munieri.sistema.contas.domain.conta.repository;

import br.com.munieri.sistema.contas.domain.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
