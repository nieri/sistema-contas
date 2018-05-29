package br.com.munieri.sistema.contas.domain.pessoa.repository;

import br.com.munieri.sistema.contas.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaCustonRepository {
}
