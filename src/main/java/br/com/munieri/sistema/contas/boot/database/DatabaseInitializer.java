package br.com.munieri.sistema.contas.boot.database;

import br.com.munieri.sistema.contas.Domain.conta.StatusConta;
import br.com.munieri.sistema.contas.Domain.conta.Conta;
import br.com.munieri.sistema.contas.Domain.conta.repository.ContaRepository;
import br.com.munieri.sistema.contas.Domain.pessoa.Pessoa;
import br.com.munieri.sistema.contas.Domain.pessoa.PessoaFisica;
import br.com.munieri.sistema.contas.Domain.pessoa.PessoaJuridica;
import br.com.munieri.sistema.contas.Domain.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DatabaseInitializer {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    ContaRepository contaRepository;

    @PostConstruct
    public void init() {

        Pessoa pessoa = new PessoaFisica("34866702800", "Murilo Nieri", LocalDate.of(1985, 11, 05));
        pessoaRepository.save(pessoa);

        Pessoa pessoa1 = new PessoaJuridica("00000000000191", "Banco do Brasil", "Banco do Brasil SA");
        pessoaRepository.save(pessoa1);

        Conta conta = new Conta("Primeira Conta", StatusConta.ATIVA, new BigDecimal(100), pessoa);
        contaRepository.save(conta);

        Conta conta1 = new Conta("Segunda Conta", StatusConta.ATIVA, new BigDecimal(200), pessoa1);
        contaRepository.save(conta1);
    }
}
