package br.com.munieri.sistema.contas.infraestructure.repository.pessoa;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaCustonRepository {
}
