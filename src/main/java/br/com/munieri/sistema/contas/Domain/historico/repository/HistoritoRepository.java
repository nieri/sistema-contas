package br.com.munieri.sistema.contas.Domain.historico.repository;

import br.com.munieri.sistema.contas.Domain.historico.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HistoritoRepository extends JpaRepository<Historico, Long> {

    @Query("SELECT h FROM Historico h WHERE h.codigoTransacao = :codigo")
    Optional<Historico> findByCodigoTransacao(@Param("codigo") String codigo);
}
