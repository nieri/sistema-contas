package br.com.munieri.sistema.contas.Domain.pessoa.repository;

import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaCustonRepository {
}
