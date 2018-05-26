package br.com.munieri.sistema.contas.boot.database;

import br.com.munieri.sistema.contas.infraestructure.repository.conta.ContaEntity;
import br.com.munieri.sistema.contas.infraestructure.repository.conta.ContaRepository;
import br.com.munieri.sistema.contas.infraestructure.repository.pessoa.PessoaEntity;
import br.com.munieri.sistema.contas.infraestructure.repository.pessoa.PessoaFisicaEntity;
import br.com.munieri.sistema.contas.infraestructure.repository.pessoa.PessoaJuridicaEntity;
import br.com.munieri.sistema.contas.infraestructure.repository.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DatabaseInitializer {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    ContaRepository contaRepository;
    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {

        PessoaEntity pessoa = new PessoaFisicaEntity("34866702800", "Murilo Nieri", LocalDate.of(1985, 11, 05));
        pessoaRepository.save(pessoa);

        PessoaEntity pessoa1 = new PessoaJuridicaEntity("00000000000191", "Banco do Brasil", "Banco do Brasil SA");
        pessoaRepository.save(pessoa1);

        ContaEntity conta = new ContaEntity("Primeira Conta", pessoa);
        contaRepository.save(conta);

        ContaEntity conta1 = new ContaEntity("Segunda Conta", pessoa1);
        contaRepository.save(conta1);
    }
}
