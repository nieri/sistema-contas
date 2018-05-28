package br.com.munieri.sistema.contas.Domain.pessoa.repository;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaCustonRepository {
}
