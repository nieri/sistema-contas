package br.com.munieri.sistema.contas.infraestructure.repository.conta;

import br.com.munieri.sistema.contas.Domain.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
