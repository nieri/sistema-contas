package br.com.munieri.sistema.contas.infraestructure.repository.historico;

import br.com.munieri.sistema.contas.Domain.historico.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoritoRepository extends JpaRepository<Historico, Long> {
}
